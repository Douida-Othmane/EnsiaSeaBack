package com.example.ensiasea.Service.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ensiasea.Constants.SecurityConstants;
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
import org.springframework.web.bind.annotation.CookieValue;

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

    public Boolean isLoggedIn(String token) {
        if (token == null) {
            return false;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.KEY.getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception ex) {
            return false;
        }

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
