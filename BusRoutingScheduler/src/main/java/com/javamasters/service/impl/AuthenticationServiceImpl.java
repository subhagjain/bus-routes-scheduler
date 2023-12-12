package com.javamasters.service.impl;

import com.javamasters.exceptions.AuthenticationException;
import com.javamasters.exceptions.RecordNotFoundException;
import com.javamasters.model.UserEntity;
import com.javamasters.request.AuthRequestDto;
import com.javamasters.service.AuthenticationService;
import com.javamasters.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author: subhag.jain
 * date: 06/12/23
 * project: BusRoutingScheduler
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long JWT_TOKEN_VALIDITY;

    @Override
    public String generateToken(AuthRequestDto authRequestDto) {
        UserEntity userEntity = userService.findAndValidateUser(authRequestDto);
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userEntity.getUsername());
    }

    @Override
    public void isAuthenticated(HttpServletRequest request) {
        final String jwtToken = request.getHeader("Authorization");

        if (jwtToken != null) {
            try {
                String username = extractUsername(jwtToken);
                UserEntity userEntity = userService.findByUsername(username);
                if (!validateToken(jwtToken, userEntity))
                    throw new AuthenticationException("JWT Token is expired");
                if (!userEntity.isAdmin() && !request.getMethod().equalsIgnoreCase("GET"))
                    throw new AuthenticationException("User is not admin, hence user cannot create or update records");
            } catch (RecordNotFoundException e) {
                throw new AuthenticationException("JWT Token is for invalid user");
            } catch (AuthenticationException e) {
                throw e;
            } catch (Exception e) {
                throw new AuthenticationException("JWT Token is invalid");
            }
        } else {
            throw new AuthenticationException("JWT Token is not present");
        }
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token, UserEntity userEntity) {
        final String username = extractUsername(token);
        return (username.equals(userEntity.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
