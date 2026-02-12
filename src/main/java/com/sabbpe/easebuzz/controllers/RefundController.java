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

import com.sabbpe.easebuzz.dto.RefundRequest;
import com.sabbpe.easebuzz.dto.RefundStatusRequest;
import com.sabbpe.easebuzz.dto.RefundV2Request;
import com.sabbpe.easebuzz.services.RefundService;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/refund"})
public class RefundController {
    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping(value={"/v1/initiate"})
    public Map<String, Object> refund(@RequestBody RefundRequest request) {
        return this.refundService.refund(request);
    }

    @PostMapping(value={"/v2/initiate"})
    public Map<String, Object> refundV2(@RequestBody RefundV2Request request) {
        return this.refundService.refundV2(request);
    }

    @PostMapping(value={"/v1/retrieve"})
    public Map<String, Object> refundStatus(@RequestBody RefundStatusRequest request) {
        return this.refundService.refundStatus(request);
    }
}
