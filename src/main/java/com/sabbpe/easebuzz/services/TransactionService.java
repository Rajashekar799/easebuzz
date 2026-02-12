/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.LinkedMultiValueMap
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
package com.sabbpe.easebuzz.services;

import com.sabbpe.easebuzz.dto.RetrieveRequest;
import com.sabbpe.easebuzz.dto.TransactionV1ByDate;
import com.sabbpe.easebuzz.dto.TransactionV2ByDateRequest;
import com.sabbpe.easebuzz.dto.TransactionV2Request;
import com.sabbpe.easebuzz.services.EasebuzzDbLogger;
import com.sabbpe.easebuzz.utils.EasebuzzLogger;
import com.sabbpe.easebuzz.utils.HashUtil;
import com.sabbpe.easebuzz.utils.ValueUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final EasebuzzDbLogger dbLogger;
    @Value(value="${easebuzz.key}")
    private String key;
    @Value(value="${easebuzz.salt}")
    private String salt;
    @Value(value="${easebuzz.url.transaction.v1}")
    private String transactionV1Url;
    @Value(value="${easebuzz.url.transaction.v1.date}")
    private String transactionV1DateUrl;
    @Value(value="${easebuzz.url.transaction.v2}")
    private String transactionV2Url;
    @Value(value="${easebuzz.url.transaction.v2.date}")
    private String transactionV2DateUrl;

    public TransactionService(EasebuzzDbLogger dbLogger) {
        this.dbLogger = dbLogger;
    }

    public Map<String, Object> getTransactionV1(RetrieveRequest req) {
        String finalKey = ValueUtil.pick(req.getKey(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String plain = String.join((CharSequence)"|", finalKey, req.getTxnid(), req.getAmount(), req.getEmail(), req.getPhone(), finalSalt);
        String hash = HashUtil.sha512Hex(plain);
        LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add((Object)"key", (Object)finalKey);
        body.add((Object)"txnid", (Object)req.getTxnid());
        body.add((Object)"amount", (Object)req.getAmount());
        body.add((Object)"email", (Object)req.getEmail());
        body.add((Object)"phone", (Object)req.getPhone());
        body.add((Object)"hash", (Object)hash);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity((Object)body, (MultiValueMap)headers);
        ResponseEntity response = this.restTemplate.exchange(this.transactionV1Url, HttpMethod.POST, entity, Map.class, new Object[0]);
        EasebuzzLogger.log("V1 Transaction", req, hash, body, this.transactionV1Url, response.getBody());
        this.dbLogger.saveLog(finalKey, finalSalt, req, hash, body, this.transactionV1Url, response.getBody());
        return (Map)response.getBody();
    }

    public Map<String, Object> getTransactionV1ByDate(TransactionV1ByDate req) {
        String finalKey = ValueUtil.pick(req.getMerchant_key(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String plain = String.join((CharSequence)"|", finalKey, req.getMerchant_email(), req.getTransaction_date(), finalSalt);
        String hash = HashUtil.sha512Hex(plain);
        LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add((Object)"merchant_key", (Object)finalKey);
        body.add((Object)"transaction_date", (Object)req.getTransaction_date());
        body.add((Object)"merchant_email", (Object)req.getMerchant_email());
        body.add((Object)"hash", (Object)hash);
        body.add((Object)"submerchant_id", (Object)req.getSubmerchant_id());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity((Object)body, (MultiValueMap)headers);
        ResponseEntity response = this.restTemplate.exchange(this.transactionV1DateUrl, HttpMethod.POST, entity, Map.class, new Object[0]);
        EasebuzzLogger.log("V1 By Date Transaction", req, hash, body, this.transactionV1DateUrl, response.getBody());
        this.dbLogger.saveLog(finalKey, finalSalt, req, hash, body, this.transactionV1DateUrl, response.getBody());
        return (Map)response.getBody();
    }

    public Map<String, Object> getTransactionV2(TransactionV2Request req) {
        String finalKey = ValueUtil.pick(req.getKey(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String plain = String.join((CharSequence)"|", finalKey, req.getTxnid(), finalSalt);
        String hash = HashUtil.sha512Hex(plain);
        LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add((Object)"key", (Object)finalKey);
        body.add((Object)"txnid", (Object)req.getTxnid());
        body.add((Object)"hash", (Object)hash);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity((Object)body, (MultiValueMap)headers);
        ResponseEntity response = this.restTemplate.exchange(this.transactionV2Url, HttpMethod.POST, entity, Map.class, new Object[0]);
        EasebuzzLogger.log("V2 Transaction - SUCCESS", req, hash, body, this.transactionV2Url, response.getBody());
        this.dbLogger.saveLog(finalKey, finalSalt, req, hash, body, this.transactionV2Url, response.getBody());
        return (Map)response.getBody();
    }

    public Map<String, Object> getTransactionV2ByDate(TransactionV2ByDateRequest req) {
        boolean tokenMode;
        String finalKey = ValueUtil.pick(req.getKey(), this.key);
        String finalSalt = ValueUtil.pick(req.getSalt(), this.salt);
        String startDate = req.getDate_range().getStart_date();
        String endDate = req.getDate_range().getEnd_date();
        String hashValue = "";
        boolean bl = tokenMode = req.getToken() != null && !req.getToken().trim().isEmpty();
        if (!tokenMode) {
            String plain = String.join((CharSequence)"|", finalKey, req.getMerchant_email(), startDate, endDate, finalSalt);
            hashValue = HashUtil.sha512Hex(plain);
        }
        LinkedHashMap<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("key", finalKey);
        body.put("merchant_email", req.getMerchant_email());
        body.put("submerchant_id", req.getSubmerchant_id());
        body.put("page", req.getPage());
        LinkedHashMap<String, String> dateRange = new LinkedHashMap<String, String>();
        dateRange.put("start_date", startDate);
        dateRange.put("end_date", endDate);
        body.put("date_range", dateRange);
        if (tokenMode) {
            body.put("token", req.getToken());
        } else {
            body.put("hash", hashValue);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(body, (MultiValueMap)headers);
        ResponseEntity response = this.restTemplate.exchange(this.transactionV2DateUrl, HttpMethod.POST, entity, Map.class, new Object[0]);
        EasebuzzLogger.log("V2 By Date Transaction", req, hashValue, body, this.transactionV2DateUrl, response.getBody());
        this.dbLogger.saveLog(finalKey, finalSalt, req, hashValue, body, this.transactionV2DateUrl, response.getBody());
        return (Map)response.getBody();
    }
}
