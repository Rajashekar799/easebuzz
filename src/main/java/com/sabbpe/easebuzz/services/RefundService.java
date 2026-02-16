/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.HttpClientErrorException
 *  org.springframework.web.client.RestTemplate
 */
package com.sabbpe.easebuzz.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabbpe.easebuzz.dto.RefundRequest;
import com.sabbpe.easebuzz.dto.RefundStatusRequest;
import com.sabbpe.easebuzz.dto.RefundV2Request;
// ...existing code...
import com.sabbpe.easebuzz.utils.EasebuzzLogger;
import com.sabbpe.easebuzz.utils.HashUtil;
import com.sabbpe.easebuzz.utils.ValueUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RefundService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final EasebuzzDbLogger dbLogger;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Value(value="${easebuzz.key}")
    private String key;
    @Value(value="${easebuzz.salt}")
    private String salt;
    @Value(value="${easebuzz.url.refund}")
    private String refundUrl;
    @Value(value="${easebuzz.url.refund.v2}")
    private String refundV2Url;
    @Value(value="${easebuzz.url.refund.status}")
    private String refundStatusUrl;

    public RefundService(EasebuzzDbLogger dbLogger) {
        this.dbLogger = dbLogger;
    }

    public Map<String, Object> refund(RefundRequest req) {
        String finalKey = ValueUtil.pick(req.getKey(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String plain = String.join((CharSequence)"|", finalKey, Objects.toString(req.getTxnid(), ""), Objects.toString(req.getAmount(), ""), Objects.toString(req.getRefund_amount(), ""), Objects.toString(req.getEmail(), ""), Objects.toString(req.getPhone(), ""), finalSalt);
        String hashValue = HashUtil.sha512Hex(plain);
        LinkedHashMap<String, String> body = new LinkedHashMap<String, String>();
        body.put("key", finalKey);
        body.put("txnid", req.getTxnid());
        body.put("amount", req.getAmount());
        body.put("refund_amount", req.getRefund_amount());
        body.put("email", req.getEmail());
        body.put("phone", req.getPhone());
        body.put("hash", hashValue);
        body.put("udf1", req.getUdf1());
        body.put("udf2", req.getUdf2());
        body.put("udf3", req.getUdf3());
        body.put("udf4", req.getUdf4());
        body.put("udf5", req.getUdf5());
        body.put("udf6", req.getUdf6());
        body.put("udf7", req.getUdf7());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LinkedHashMap<String, String>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Map<String, Object>> response = this.restTemplate.exchange(this.refundUrl, HttpMethod.POST, entity, (Class<Map<String, Object>>) (Class<?>) Map.class, new Object[0]);
        EasebuzzLogger.log("Refund API", req, hashValue, body, this.refundUrl, response.getBody());
        this.dbLogger.saveLog(finalKey, finalSalt, req, hashValue, body, this.refundUrl, response.getBody());
        return response.getBody();
    }

    public Map<String, Object> refundV2(RefundV2Request req) {
        RefundV2Request clientPayload = new RefundV2Request(req.getKey(), req.getSalt(), req.getMerchant_refund_id(), req.getEasebuzz_id(), req.getRefund_amount(), req.getUdf1(), req.getUdf2(), req.getUdf3(), req.getUdf4(), req.getUdf5(), req.getUdf6(), req.getUdf7(), req.getSplit_labels());
        String finalKey = ValueUtil.pick(req.getKey(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String merchantRefundId = "REF-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        req.setMerchant_refund_id(merchantRefundId);
        String plain = String.join((CharSequence)"|", finalKey, req.getMerchant_refund_id(), req.getEasebuzz_id(), req.getRefund_amount(), finalSalt);
        String hashValue = HashUtil.sha512Hex(plain);
        LinkedHashMap<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("key", finalKey);
        body.put("merchant_refund_id", merchantRefundId);
        body.put("easebuzz_id", req.getEasebuzz_id());
        body.put("refund_amount", req.getRefund_amount());
        body.put("hash", hashValue);
        body.put("udf1", req.getUdf1());
        body.put("udf2", req.getUdf2());
        body.put("udf3", req.getUdf3());
        body.put("udf4", req.getUdf4());
        body.put("udf5", req.getUdf5());
        body.put("udf6", req.getUdf6());
        body.put("udf7", req.getUdf7());
        if (req.getSplit_labels() != null) {
            body.put("split_labels", req.getSplit_labels());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LinkedHashMap<String, Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Map<String, Object>> response = this.restTemplate.exchange(this.refundV2Url, HttpMethod.POST, entity, (Class<Map<String, Object>>) (Class<?>) Map.class, new Object[0]);
        EasebuzzLogger.log("V2 Refund", clientPayload, hashValue, body, this.refundV2Url, response.getBody());
        this.dbLogger.saveLog(finalKey, finalSalt, clientPayload, hashValue, body, this.refundV2Url, response.getBody());
        return response.getBody();
    }

    public Map<String, Object> refundStatus(RefundStatusRequest req) {
        RefundStatusRequest clientPayload = new RefundStatusRequest(req.getKey(), req.getSalt(), req.getEasebuzz_id(), req.getMerchant_refund_id());
        String finalKey = ValueUtil.pick(req.getKey(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String plain = String.join((CharSequence)"|", finalKey, req.getEasebuzz_id(), finalSalt);
        String hashValue = HashUtil.sha512Hex(plain);
        LinkedHashMap<String, String> body = new LinkedHashMap<String, String>();
        body.put("key", finalKey);
        body.put("easebuzz_id", req.getEasebuzz_id());
        body.put("merchant_refund_id", req.getMerchant_refund_id());
        body.put("hash", hashValue);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LinkedHashMap<String, String>> entity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<Map<String, Object>> response = this.restTemplate.exchange(this.refundStatusUrl, HttpMethod.POST, entity, (Class<Map<String, Object>>) (Class<?>) Map.class, new Object[0]);
            EasebuzzLogger.log("Refund Status API", clientPayload, hashValue, body, this.refundStatusUrl, response.getBody());
            this.dbLogger.saveLog(finalKey, finalSalt, clientPayload, hashValue, body, this.refundStatusUrl, response.getBody());
            return response.getBody();
        }
        catch (HttpClientErrorException ex) {
            Object errorResponse;
            try {
                errorResponse = this.objectMapper.readValue(ex.getResponseBodyAsString(), Object.class);
            }
            catch (Exception jsonEx) {
                errorResponse = ex.getResponseBodyAsString();
            }
            EasebuzzLogger.log("Refund Status API - ERROR", clientPayload, hashValue, body, this.refundStatusUrl, errorResponse);
            this.dbLogger.saveLog(finalKey, finalSalt, clientPayload, hashValue, body, this.refundStatusUrl, errorResponse);
            throw ex;
        }
    }
}
