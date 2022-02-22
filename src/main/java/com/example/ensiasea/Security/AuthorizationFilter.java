package com.example.ensiasea.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ensiasea.Constants.SecurityConstants;
import com.example.ensiasea.Security.JWT.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/api/v1/auth/register")
                || request.getServletPath().equals("/api/v1/auth/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        String authorizationHeader = JwtUtil.getJwtFromCookies(request);
        if (authorizationHeader != null) {
            try {
                System.out.println(authorizationHeader);
                String token = authorizationHeader;
                Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.KEY.getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String email = decodedJWT.getSubject();
                String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                Arrays.stream(roles).forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role));
                });
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        email, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);

            } catch (Exception exception) {
                System.out.print(exception);
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
            return;
        }
    }

}