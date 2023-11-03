package com.example.demodemo.controller;


import com.example.demodemo.entity.UserRegistrationFormEntity;
import com.example.demodemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/get_auth")
    public String getAuth(UserRegistrationFormEntity entity) {
        return authService.register(entity);
    }
}
