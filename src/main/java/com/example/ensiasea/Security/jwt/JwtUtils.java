package com.example.ensiasea.Security.jwt;

import java.security.Key;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.example.ensiasea.Security.Service.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${othmane.app.jwtSecret}")
  private String jwtSecret;

  @Value("${othmane.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  @Value("${othmane.app.jwtCookieName}")
  private String jwtCookie;

  public String getJwtFromCookies(HttpServletRequest request) {
    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }
  public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
    return cookie;
  }
  public ResponseCookie getCleanJwtCookie() {
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
    return cookie;
  }
  public String getUserNameFromJwtToken(String token) {
    return ((JwtParser) Jwts.parserBuilder() 
      .setSigningKey(jwtSecret))
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }
  public boolean validateJwtToken(String authToken) {
    try {
      ((JwtParser) Jwts.parserBuilder().setSigningKey(jwtSecret)).parseClaimsJws(authToken);
      return true;
  //  } catch (SignatureException e) {
   //   logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }
    return false;
  }

  public String JWT_SECRET;
  
  public String generateTokenFromUsername(String username) {
    Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();
  }
}
