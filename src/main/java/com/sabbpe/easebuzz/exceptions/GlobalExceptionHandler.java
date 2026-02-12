package com.sabbpe.easebuzz.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private String extractEasebuzzMessage(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> json = mapper.readValue(response, Map.class);

            if (json.containsKey("error_desc")) {
                return json.get("error_desc").toString();
            }

            if (json.containsKey("validation_errors")) {
                Map<?, ?> errors = (Map<?, ?>) json.get("validation_errors");
                if (!errors.isEmpty()) {
                    return errors.values().iterator().next().toString();
                }
            }

        } catch (Exception ignored) {
        }

        return "Something went wrong. Please try again.";
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, Object>> handleHttpClientError(HttpClientErrorException ex) {

        String cleanMessage = extractEasebuzzMessage(ex.getResponseBodyAsString());

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", cleanMessage);
        response.put("status", ex.getStatusCode().value());

        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralError(Exception ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", ex.getMessage());
        response.put("status", 500);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
