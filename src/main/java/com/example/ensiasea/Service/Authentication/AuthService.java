package com.example.ensiasea.Service.Authentication;

import com.example.ensiasea.Models.User;
import com.example.ensiasea.Payload.LoginCreds;
import com.example.ensiasea.Payload.RegistrationRequest;
import com.example.ensiasea.Response.LoginResponse;
import com.example.ensiasea.Security.JWT.JwtUtil;
import com.example.ensiasea.Service.UserService;

import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtils;

    public User register(RegistrationRequest request) {
        return userService.register(new User(request.getUsername(), request.getEmail(), request.getPassword()));
    }

    public LoginResponse login(LoginCreds loginCreds) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginCreds.getEmail(), loginCreds.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(authentication);
            return new LoginResponse(true, jwtCookie, "User logged in successfully", null);
        } catch (Exception ex) {
            return new LoginResponse(false, null, null, "Bad Creds");
        }
    }
}
