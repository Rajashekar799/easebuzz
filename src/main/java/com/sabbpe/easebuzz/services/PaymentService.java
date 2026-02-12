package com.sabbpe.easebuzz.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabbpe.easebuzz.dto.InitiateRequest;
import com.sabbpe.easebuzz.models.EasebuzzPaymentCallback;
import com.sabbpe.easebuzz.models.PaymentStatus;
import com.sabbpe.easebuzz.repositories.EasebuzzPaymentCallbackRepository;
import com.sabbpe.easebuzz.utils.HashUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final EasebuzzPaymentCallbackRepository callbackRepository;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Value("${easebuzz.key}")
    private String merchantKey;

    @Value("${easebuzz.salt}")
    private String salt;

    @Value("${easebuzz.url.initiate}")
    private String initiateUrl;

    /* ============================================================
       REAL INITIATE PAYMENT INTEGRATION
       ============================================================ */

    public Map<String, Object> initiatePayment(InitiateRequest request) {

        try {

            String hashString = String.join("|",
                    merchantKey,
                    request.getTxnid(),
                    request.getAmount(),
                    request.getProductinfo(),
                    request.getFirstname(),
                    request.getEmail(),
                    safe(request.getUdf1()),
                    safe(request.getUdf2()),
                    safe(request.getUdf3()),
                    safe(request.getUdf4()),
                    safe(request.getUdf5()),
                    "", "", "", "", "",
                    salt
            );

            String hash = HashUtil.sha512Hex(hashString);

            Map<String, String> payload = new HashMap<>();
            payload.put("key", merchantKey);
            payload.put("txnid", request.getTxnid());
            payload.put("amount", request.getAmount());
            payload.put("productinfo", request.getProductinfo());
            payload.put("firstname", request.getFirstname());
            payload.put("email", request.getEmail());
            payload.put("phone", request.getPhone());
            payload.put("surl", request.getSurl());
            payload.put("furl", request.getFurl());
            payload.put("hash", hash);

            log.info("Calling Easebuzz initiate API for txnId={}", request.getTxnid());

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(initiateUrl, payload, Map.class);

            return response.getBody();

        } catch (Exception e) {
            log.error("Error initiating payment", e);
            return Map.of("status", "ERROR", "message", e.getMessage());
        }
    }

    /* ============================================================
       IDEMPOTENT CALLBACK PROCESSING
       ============================================================ */

    @Transactional
    public void processCallback(Map<String, String> callbackData) {

        String txnid = safe(callbackData.get("txnid"));

        if (txnid.isBlank()) {
            log.warn("Callback received without txnId. Ignoring.");
            return;
        }

        String receivedHash = safe(callbackData.get("hash"));
        String status = safe(callbackData.get("status"));
        String key = safe(callbackData.get("key"));
        String email = safe(callbackData.get("email"));
        String firstname = safe(callbackData.get("firstname"));
        String productinfo = safe(callbackData.get("productinfo"));
        String amount = safe(callbackData.get("amount"));

        log.info("Processing Easebuzz callback txnId={}, status={}", txnid, status);

        boolean hashValid = false;

        if (merchantKey.equals(key)) {

            String reverseHash = String.join("|",
                    salt,
                    status,
                    "", "", "", "", "", "", "", "", "", "",
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
                    txnid,
                    key
            );

            String calculatedHash = HashUtil.sha512Hex(reverseHash);

            hashValid = MessageDigest.isEqual(
                    calculatedHash.getBytes(StandardCharsets.UTF_8),
                    receivedHash.getBytes(StandardCharsets.UTF_8)
            );
        }

        PaymentStatus paymentStatus =
                ("success".equalsIgnoreCase(status) && hashValid)
                        ? PaymentStatus.SUCCESS
                        : PaymentStatus.FAILED;

        String rawResponse;
        try {
            rawResponse = objectMapper.writeValueAsString(callbackData);
        } catch (Exception e) {
            rawResponse = callbackData.toString();
        }

        Optional<EasebuzzPaymentCallback> existing =
                callbackRepository.findByTxnId(txnid);

        EasebuzzPaymentCallback entity;

        if (existing.isPresent()) {
            entity = existing.get();
            log.info("Updating existing txnId={}", txnid);
        } else {
            entity = new EasebuzzPaymentCallback();
            entity.setTxnId(txnid);
            entity.setCreatedAt(LocalDateTime.now());
            log.info("Creating new txnId={}", txnid);
        }

        entity.setAmount(amount);
        entity.setStatus(status);
        entity.setPaymentStatus(paymentStatus.name());
        entity.setCustomerName(firstname);
        entity.setEmail(email);
        entity.setPhone(safe(callbackData.get("phone")));
        entity.setGatewayMode(safe(callbackData.get("mode")));
        entity.setHash(receivedHash);
        entity.setHashValidated(hashValid);
        entity.setRawResponse(rawResponse);
        entity.setUpdatedAt(LocalDateTime.now());

        callbackRepository.save(entity);

        log.info("Callback stored successfully txnId={}, paymentStatus={}", txnid, paymentStatus);
    }

    private String safe(String value) {
        return value == null ? "" : value.trim();
    }
}
