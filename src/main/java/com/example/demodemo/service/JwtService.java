package com.example.demodemo.service;


import com.example.demodemo.entity.UserRegistrationFormEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.expiration}")
    private String jwtExpiration;

    public String generateToken(UserRegistrationFormEntity userRegistrationFormEntity){
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
}


