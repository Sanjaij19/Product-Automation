package com.example.Product_Automation_Back_End.Payload.Request;

import lombok.Data;

@Data
public class LogInRequest {

    private String email;
    private String password;
}
