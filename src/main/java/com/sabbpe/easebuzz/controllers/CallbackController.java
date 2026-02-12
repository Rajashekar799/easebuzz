package com.sabbpe.easebuzz.controllers;

import com.sabbpe.easebuzz.services.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/payments/easebuzz")
@RequiredArgsConstructor
public class CallbackController {

    private final PaymentService paymentService;

    /**
     * Easebuzz Callback Endpoint
     * Supports both GET and POST
     */
    @RequestMapping(
            value = "/callback",
            method = {RequestMethod.POST, RequestMethod.GET}
    )
    public Map<String, Object> handleCallback(HttpServletRequest request) {

        Map<String, String> callbackData = new HashMap<>();

        // Extract all parameters from request
        request.getParameterMap().forEach((key, value) -> {
            if (value != null && value.length > 0) {
                callbackData.put(key, value[0]);
            }
        });

        log.info("Easebuzz callback received | txnId={} | status={} | amount={} | mode={}",
                callbackData.get("txnid"),
                callbackData.get("status"),
                callbackData.get("amount"),
                callbackData.get("mode")
        );

        try {
            paymentService.processCallback(callbackData);
        } catch (Exception e) {
            log.error("Error processing Easebuzz callback for txnId={}",
                    callbackData.get("txnid"), e);
        }

        // Always return 200 so gateway does not retry
        return Map.of(
                "success", true,
                "message", "Callback processed successfully"
        );
    }
}
