package com.sabbpe.easebuzz.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabbpe.easebuzz.dto.FrontendPaymentRequest;
import com.sabbpe.easebuzz.dto.InitiateRequest;
import com.sabbpe.easebuzz.models.EasebuzzPaymentCallback;
import com.sabbpe.easebuzz.repositories.EasebuzzPaymentCallbackRepository;
import com.sabbpe.easebuzz.utils.HashUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final EasebuzzPaymentCallbackRepository callbackRepository;
    private final ObjectMapper objectMapper;

    @Value("${easebuzz.key}")
    private String merchantKey;

    @Value("${easebuzz.salt}")
    private String salt;

    @Value("${easebuzz.url.initiate}")
    private String initiateUrl;

    /* ============================================================
       INITIATE PAYMENT
       ============================================================ */
    public Map<String, Object> initiatePayment(InitiateRequest request) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            String hashString = merchantKey + "|" +
                    request.getTxnid() + "|" +
                    request.getAmount() + "|" +
                    request.getProductinfo() + "|" +
                    request.getFirstname() + "|" +
                    request.getEmail() + "|" +
                    safe(request.getUdf1()) + "|" +
                    safe(request.getUdf2()) + "|" +
                    safe(request.getUdf3()) + "|" +
                    safe(request.getUdf4()) + "|" +
                    safe(request.getUdf5()) + "||||||" +
                    salt;

            String hash = HashUtil.sha512Hex(hashString);

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("key", merchantKey);
            body.add("txnid", request.getTxnid());
            body.add("amount", request.getAmount());
            body.add("productinfo", request.getProductinfo());
            body.add("firstname", request.getFirstname());
            body.add("email", request.getEmail());
            body.add("phone", request.getPhone());
            body.add("surl", request.getSurl());
            body.add("furl", request.getFurl());
            body.add("hash", hash);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> entity =
                    new HttpEntity<>(body, headers);

            ResponseEntity<String> response =
                    restTemplate.postForEntity(initiateUrl, entity, String.class);

            log.info("Easebuzz Raw Response: {}", response.getBody());

            Map<String, Object> easebuzzMap =
                    objectMapper.readValue(response.getBody(), Map.class);

            if (Integer.valueOf(1).equals(easebuzzMap.get("status"))) {

                String accessKey = (String) easebuzzMap.get("data");

                String paymentUrl =
                        "https://testpay.easebuzz.in/pay/" + accessKey;

                return Map.of(
                        "success", true,
                        "paymentUrl", paymentUrl
                );
            }

            return Map.of(
                    "success", false,
                    "error", easebuzzMap.get("error_desc")
            );

        } catch (Exception e) {
            log.error("Error initiating payment", e);
            return Map.of(
                    "success", false,
                    "error", e.getMessage()
            );
        }
    }

    /* ============================================================
       FRONTEND INITIATE
       ============================================================ */
    public Map<String, Object> initiatePaymentFromFrontend(
            FrontendPaymentRequest frontendRequest) {

        InitiateRequest request = new InitiateRequest();

        String txnId = "TXN" + System.currentTimeMillis();

        request.setTxnid(txnId);
        request.setAmount(frontendRequest.getAmount());
        request.setProductinfo("Test Product");
        request.setFirstname(frontendRequest.getName());
        request.setEmail(frontendRequest.getEmail());
        request.setPhone(frontendRequest.getPhone());

        request.setSurl("http://localhost:8080/api/payments/easebuzz/callback");
        request.setFurl("http://localhost:8080/api/payments/easebuzz/callback");

        return initiatePayment(request);
    }

    /* ============================================================
       CALLBACK HANDLING
       ============================================================ */
    @Transactional
    public void processCallback(Map<String, String> callbackData) {

        log.info("FULL CALLBACK DATA: {}", callbackData);

        String txnId = safe(callbackData.get("txnid"));

        if (txnId.isBlank()) {
            log.warn("Callback received without txnId. Ignoring.");
            return;
        }

        String receivedHash = safe(callbackData.get("hash")).trim();
        String status = safe(callbackData.get("status")).trim();
        String key = safe(callbackData.get("key")).trim();
        String email = safe(callbackData.get("email")).trim();
        String firstname = safe(callbackData.get("firstname")).trim();
        String productinfo = safe(callbackData.get("productinfo")).trim();
        String amount = safe(callbackData.get("amount")).trim();

        boolean hashValid = false;
        String calculatedHash = "";

        if (merchantKey.equals(key)) {

            String reverseHash = String.join("|",
                    salt.trim(),
                    status,
                    safe(callbackData.get("udf10")),
                    safe(callbackData.get("udf9")),
                    safe(callbackData.get("udf8")),
                    safe(callbackData.get("udf7")),
                    safe(callbackData.get("udf6")),
                    safe(callbackData.get("udf5")),
                    safe(callbackData.get("udf4")),
                    safe(callbackData.get("udf3")),
                    safe(callbackData.get("udf2")),
                    safe(callbackData.get("udf1")),
                    email,
                    firstname,
                    productinfo,
                    amount,
                    txnId,
                    merchantKey.trim()
            );

            calculatedHash = HashUtil.sha512Hex(reverseHash);
            hashValid = calculatedHash.trim()
                    .equalsIgnoreCase(receivedHash.trim());
        }

        String finalPaymentStatus;

        if (!hashValid) {
            finalPaymentStatus = "HASH_MISMATCH";
        } else {
            switch (status.toLowerCase()) {

                case "success":
                    finalPaymentStatus = "SUCCESS";
                    break;

                case "failure":
                    finalPaymentStatus = "FAILED";
                    break;

                case "usercancelled":
                case "cancel":
                    finalPaymentStatus = "CANCELLED";
                    break;

                case "timeout":
                    finalPaymentStatus = "TIMEOUT";
                    break;

                case "pending":
                    finalPaymentStatus = "PENDING";
                    break;

                case "delayed_success":
                    finalPaymentStatus = "DELAYED_SUCCESS";
                    break;

                case "delayed_failure":
                    finalPaymentStatus = "DELAYED_FAILURE";
                    break;

                case "session_timeout":
                    finalPaymentStatus = "SESSION_TIMEOUT";
                    break;

                default:
                    finalPaymentStatus = "UNKNOWN";
            }
        }

        String rawResponse;
        try {
            rawResponse = objectMapper.writeValueAsString(callbackData);
        } catch (Exception e) {
            rawResponse = callbackData.toString();
        }

        Optional<EasebuzzPaymentCallback> existing =
                callbackRepository.findByTxnId(txnId);

        EasebuzzPaymentCallback entity;

        if (existing.isPresent()) {

            entity = existing.get();
            entity.setStatus(status);
            entity.setPaymentStatus(finalPaymentStatus);
            entity.setHash(receivedHash);
            entity.setHashValidated(hashValid);
            entity.setRawResponse(rawResponse);
            entity.setUpdatedAt(LocalDateTime.now());

        } else {

            entity = EasebuzzPaymentCallback.builder()
                    .txnId(txnId)
                    .amount(amount)
                    .status(status)
                    .paymentStatus(finalPaymentStatus)
                    .customerName(firstname)
                    .email(email)
                    .phone(safe(callbackData.get("phone")))
                    .gatewayMode(safe(callbackData.get("mode")))
                    .hash(receivedHash)
                    .hashValidated(hashValid)
                    .rawResponse(rawResponse)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }

        callbackRepository.save(entity);

        log.info("FINAL RESULT → txnId={} | paymentStatus={} | hashValid={}",
                txnId, finalPaymentStatus, hashValid);
    }

    private String safe(String value) {
        return value == null ? "" : value.trim();
    }
}
