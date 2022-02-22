package com.example.ensiasea.Security;

import java.sql.Date;
import java.util.stream.Collectors;

import javax.imageio.IIOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.ensiasea.Constants.SecurityConstants;
import com.example.ensiasea.Payload.LoginCreds;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        private final AuthenticationManager authenticationManager;

        public AuthenticationFilter(AuthenticationManager authenticationManager) {
                this.authenticationManager = authenticationManager;
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
                try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        LoginCreds loginCreds = objectMapper.readValue(request.getInputStream(), LoginCreds.class);
                        String email = loginCreds.getEmail();
                        String password = loginCreds.getPassword();
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                        email,
                                        password);
                        return authenticationManager.authenticate(authenticationToken);
                } catch (Exception exception) {
                        System.out.println(exception);
                        return null;
                }

        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                        FilterChain chain,
                        Authentication authResult) throws IIOException, ServletException {
                System.out.println("Authentication successful");
                Date exp = new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME);
                User user = (User) authResult.getPrincipal();

                Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.KEY.getBytes());

                String access_token = JWT.create().withSubject(user.getUsername())
                                .withExpiresAt(exp)
                                .withIssuer(request.getRequestURL().toString())
                                .withClaim("roles",
                                                user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                                                                .collect(Collectors.toList()))
                                .sign(algorithm);
                response.setHeader("access_token", access_token);
                Cookie cookie = new Cookie("token", access_token);
                cookie.setHttpOnly(true);
                cookie.setPath("/api/v1/");
                response.addCookie(cookie);
        }

}