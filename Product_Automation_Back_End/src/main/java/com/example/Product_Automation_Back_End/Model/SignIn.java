package com.example.Product_Automation_Back_End.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {

    private String id;
    private String userName;
    private String email;
    private String password;
    private String role;
}
