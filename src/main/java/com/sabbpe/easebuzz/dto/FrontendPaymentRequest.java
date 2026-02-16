package com.sabbpe.easebuzz.dto;

import lombok.Data;

@Data
public class FrontendPaymentRequest {

    private String name;
    private String email;
    private String phone;
    private String amount;
}
