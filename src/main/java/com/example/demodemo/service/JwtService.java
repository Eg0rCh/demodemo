package com.example.demodemo.service;


import com.example.demodemo.entity.UserRegistrationFormEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

    private String secretKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    private long jwtExpiration = 86400000;

    public String generateToken(UserRegistrationFormEntity userRegistrationFormEntity) {
        Date issuedDate = new Date();
        Date expiration = new Date(issuedDate.getTime() + jwtExpiration);

        return Jwts.builder()
                .setSubject(userRegistrationFormEntity.getEmail())
                .setIssuedAt(issuedDate)
                .setExpiration(expiration)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractNickname(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}


