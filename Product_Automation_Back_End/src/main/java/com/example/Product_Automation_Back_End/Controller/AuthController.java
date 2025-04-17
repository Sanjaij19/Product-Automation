package com.example.Product_Automation_Back_End.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product_Automation_Back_End.Exception.EmailAllReadyPresent;
import com.example.Product_Automation_Back_End.Model.SignIn;
import com.example.Product_Automation_Back_End.Payload.Response.ApiResponse;
import com.example.Product_Automation_Back_End.Service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/signIn")
    public ResponseEntity<ApiResponse> postMethodName(@RequestBody SignIn user) {
        try {
            SignIn createdUser = service.saveUser(user);
            return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", createdUser));
        } catch (EmailAllReadyPresent e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "An unexpected error occurred", null));
        }
    }
    
}
