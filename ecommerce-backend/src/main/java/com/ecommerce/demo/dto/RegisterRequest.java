package com.ecommerce.demo.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String email;
    private String password;

    // Getters and Setters
}