package com.example.ensiasea.DTO;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String username;
    private String password;
}
