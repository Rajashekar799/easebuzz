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

import com.sabbpe.easebuzz.dto.FrontendPaymentRequest;
import com.sabbpe.easebuzz.dto.InitiateRequest;
import com.sabbpe.easebuzz.services.PaymentService;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/payment"})
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value={"/initiateLink"})
    public Map<String, Object> initiatePayment(
        @RequestBody InitiateRequest request)
{
    return paymentService.initiatePayment(request);
}

}
