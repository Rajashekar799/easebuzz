package com.sabbpe.easebuzz.controllers;

import com.sabbpe.easebuzz.models.EasebuzzPaymentCallback;
import com.sabbpe.easebuzz.repositories.EasebuzzPaymentCallbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentStatusController {

    private final EasebuzzPaymentCallbackRepository repository;

    @GetMapping("/status/{txnId}")
    public Map<String, Object> getPaymentStatus(@PathVariable String txnId) {

        Optional<EasebuzzPaymentCallback> optional = repository.findByTxnId(txnId);

        if (optional.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "NOT_FOUND");
            response.put("message", "No payment found for txnId: " + txnId);
            return response;
        }

        EasebuzzPaymentCallback entity = optional.get();

        Map<String, Object> response = new HashMap<>();
        response.put("txnId", entity.getTxnId());
        response.put("status", entity.getStatus());
        response.put("paymentStatus", entity.getPaymentStatus());
        response.put("hashValidated", entity.getHashValidated());
        response.put("amount", entity.getAmount());
        response.put("gatewayMode", entity.getGatewayMode());
        response.put("createdAt", entity.getCreatedAt());

        return response;
    }
}
