package com.example.ensiasea.Controller.Authentication;

import com.example.ensiasea.DTO.RegistrationRequest;
import com.example.ensiasea.Models.User;
import com.example.ensiasea.Service.Authentication.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class RegisterController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
