package com.example.ensiasea.Controller.Authentication;

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
import org.springframework.web.bind.annotation.CookieValue;
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
        try {
            LoginResponse loginResponse = authService.login(loginCreds);
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, loginResponse.getCookie().toString())
                    .body(loginResponse);

        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse(false, "Error While Loggin In"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        authService.register(request);
        return ResponseEntity.ok()
                .body(new MessageResponse(true, "User registered successfully!"));
    }

    @PostMapping("/isloggedin")
    public ResponseEntity<?> isLogin(@CookieValue(name = "token") String token) {

        return ResponseEntity.ok()
                .body(new MessageResponse(authService.isLoggedIn(token),
                        authService.isLoggedIn(token) ? "User already Logged in !"
                                : "User Not logged in!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = JwtUtil.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse(true, "You've been signed out!"));
    }

}