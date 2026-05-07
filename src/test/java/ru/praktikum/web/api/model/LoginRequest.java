package ru.praktikum.web.api.model;


import lombok.Data;

@Data
public class LoginRequest {
    private final String email;
    private final String password;
}
