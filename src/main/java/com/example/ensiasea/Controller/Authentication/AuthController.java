package com.example.ensiasea.Controller.Authentication;

import com.example.ensiasea.Models.User;
import com.example.ensiasea.Payload.LoginCreds;
import com.example.ensiasea.Payload.RegistrationRequest;

import com.example.ensiasea.Response.LoginResponse;
import com.example.ensiasea.Response.MessageResponse;
import com.example.ensiasea.Security.JWT.JwtUtil;
import com.example.ensiasea.Service.Authentication.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginCreds loginCreds) {

        LoginResponse loginResponse = authService.login(loginCreds);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, loginResponse.getCookie().toString())
                .body(loginResponse);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest request) {
        return authService.register(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = JwtUtil.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

}