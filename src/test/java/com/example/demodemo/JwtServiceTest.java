package com.example.demodemo;

import com.example.demodemo.entity.UserRegistrationFormEntity;
import com.example.demodemo.service.JwtService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class JwtServiceTest {
    @Autowired
    private JwtService jwtService;
    @Test
    public void testGenerateToken() {
        UserRegistrationFormEntity user = new UserRegistrationFormEntity();
        user.setEmail("test@example.com");

        String token = jwtService.generateToken(user);

        assertNotNull(token);

        // Verify that the token is a valid JWT

    }
}
