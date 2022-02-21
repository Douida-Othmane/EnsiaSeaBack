package com.example.ensiasea.Service.Authentication;

import javax.xml.ws.soap.Addressing;

import com.example.ensiasea.DTO.RegistrationRequest;
import com.example.ensiasea.Models.User;
import com.example.ensiasea.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserService userService;

    public User register(RegistrationRequest request) {
        return userService.register(new User(request.getUsername(), request.getEmail(), request.getPassword()));
    }

}
