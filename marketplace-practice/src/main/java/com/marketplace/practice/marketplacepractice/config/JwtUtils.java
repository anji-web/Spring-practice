package com.marketplace.practice.marketplacepractice.config;

import com.marketplace.practice.marketplacepractice.helper.UsersDetailImpl;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expiration.millisecond}")
  private int jwtExpiration;

  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  public String generateJwtToken(Authentication authentication){
    UsersDetailImpl usersPrincipal = (UsersDetailImpl) authentication.getPrincipal();

    return Jwts.builder()
        .setSubject(usersPrincipal.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public String getUsernameFromToken(String token){
      return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
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
}
