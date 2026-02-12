package com.sabbpe.easebuzz.controllers;

import com.sabbpe.easebuzz.exceptions.InvalidHashException;
import com.sabbpe.easebuzz.services.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/payments/easebuzz")
@RequiredArgsConstructor
public class CallbackController {

    private final PaymentService paymentService;

    @PostMapping(
            value = "/callback",
            consumes = "application/x-www-form-urlencoded"
    )
    public ResponseEntity<Map<String, String>> handleCallback(
            @RequestParam Map<String, String> callbackData,
            HttpServletRequest request) {

        String txnId = callbackData.get("txnid");
        String status = callbackData.get("status");
        String amount = callbackData.get("amount");
        String mode = callbackData.get("mode");
        String clientIp = request.getRemoteAddr();

        log.info("Easebuzz callback received | txnId={} | status={} | amount={} | mode={} | IP={}",
                txnId, status, amount, mode, clientIp);

        try {
            paymentService.processCallback(callbackData);
        } catch (InvalidHashException e) {
            log.error("Invalid hash detected for txnId={} | reason={}", txnId, e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error while processing callback txnId={}", txnId, e);
        }

        // Always return 200 so gateway does not retry
        return ResponseEntity.ok(Map.of("message", "Received"));
    }
}
