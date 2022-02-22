package com.example.ensiasea.Service.Authentication;

import javax.xml.ws.soap.Addressing;

import com.example.ensiasea.Models.User;
import com.example.ensiasea.Payload.LoginCreds;
import com.example.ensiasea.Payload.RegistrationRequest;
import com.example.ensiasea.Repository.RoleRepo;
import com.example.ensiasea.Repository.UserRepo;
import com.example.ensiasea.Response.LoginResponse;
import com.example.ensiasea.Security.JWT.JwtUtil;
import com.example.ensiasea.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepository;
    private final RoleRepo roleRepository;
    private final PasswordEncoder encoder;
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
