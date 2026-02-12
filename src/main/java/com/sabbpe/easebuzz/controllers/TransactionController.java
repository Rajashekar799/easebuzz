/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.sabbpe.easebuzz.controllers;

import com.sabbpe.easebuzz.dto.RetrieveRequest;
import com.sabbpe.easebuzz.dto.TransactionV1ByDate;
import com.sabbpe.easebuzz.dto.TransactionV2ByDateRequest;
import com.sabbpe.easebuzz.dto.TransactionV2Request;
import com.sabbpe.easebuzz.services.TransactionService;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/transaction"})
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value={"/v1/retrieve"})
    public Map<String, Object> retrieveTransactionV1(@RequestBody RetrieveRequest request) {
        return this.transactionService.getTransactionV1(request);
    }

    @PostMapping(value={"/v1/retrieve/date"})
    public Map<String, Object> retrieveTransactionV1Date(@RequestBody TransactionV1ByDate request) {
        return this.transactionService.getTransactionV1ByDate(request);
    }

    @PostMapping(value={"/v2/retrieve"})
    public Map<String, Object> retrieveTransactionV2(@RequestBody TransactionV2Request request) {
        return this.transactionService.getTransactionV2(request);
    }

    @PostMapping(value={"/v2/retrieve/date"})
    public Map<String, Object> retrieveTransactionV2Date(@RequestBody TransactionV2ByDateRequest request) {
        return this.transactionService.getTransactionV2ByDate(request);
    }
}
