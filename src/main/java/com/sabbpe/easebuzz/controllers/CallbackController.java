package com.sabbpe.easebuzz.controllers;

import com.sabbpe.easebuzz.services.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/api/payments/easebuzz")
@RequiredArgsConstructor
public class CallbackController {

    private final PaymentService paymentService;

    @RequestMapping(
            value = "/callback",
            method = {RequestMethod.POST, RequestMethod.GET}
    )
    @ResponseBody
    public String handleCallback(HttpServletRequest request) {

        Map<String, String> callbackData = new HashMap<>();

        request.getParameterMap().forEach((key, value) -> {
            if (value != null && value.length > 0) {
                callbackData.put(key, value[0]);
            }
        });

        log.info("FULL CALLBACK DATA: {}", callbackData);

        String txnId = callbackData.get("txnid");
        String status = callbackData.get("status");
        String amount = callbackData.get("amount");

        try {
            paymentService.processCallback(callbackData);
        } catch (Exception e) {
            log.error("Error processing callback", e);
        }

        String title;
        String color;
        String message;

        switch (status == null ? "" : status.toLowerCase()) {

            case "success":
                title = "Payment Successful";
                color = "green";
                message = "Your payment has been completed successfully.";
                break;

            case "failure":
                title = "Payment Failed";
                color = "red";
                message = "Your payment has failed. Please try again.";
                break;

            case "usercancelled":
            case "cancel":
                title = "Payment Cancelled";
                color = "orange";
                message = "You cancelled the payment.";
                break;

            case "pending":
                title = "Payment Pending";
                color = "blue";
                message = "Your payment is being processed. Please wait.";
                break;

            case "timeout":
                title = "Session Timeout";
                color = "purple";
                message = "Payment session timed out.";
                break;

            default:
                title = "Payment Status Unknown";
                color = "gray";
                message = "Unable to determine payment status.";
        }

        return """
                <html>
                <body style="text-align:center;margin-top:60px;font-family:Arial;">
                    <h2 style="color:%s;">%s</h2>
                    <p><strong>Transaction ID:</strong> %s</p>
                    <p><strong>Amount:</strong> %s</p>
                    <p>%s</p>
                    <br/>
                    <a href="/" style="text-decoration:none;color:white;background:black;padding:10px 20px;border-radius:5px;">
                        Back to Home
                    </a>
                </body>
                </html>
                """.formatted(color, title, txnId, amount, message);
    }
}
