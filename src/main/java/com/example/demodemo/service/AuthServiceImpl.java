package com.example.demodemo.service;

import com.example.demodemo.dto.RegistrationRequest;
import com.example.demodemo.dto.RegistrationResponse;
import com.example.demodemo.entity.UserRegistrationFormEntity;
import com.example.demodemo.repository.UserRegistrationFormRepository;
import com.example.demodemo.token.Token;
import com.example.demodemo.token.TokenRepository;
import com.example.demodemo.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRegistrationFormRepository repository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public RegistrationResponse register(RegistrationRequest userDto) {
        var user = UserRegistrationFormEntity.builder()
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        logger.info("User registered successfully: {}", user.getNickname());
        logger.debug("JWT token generated: {}", jwtToken);
        return RegistrationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    private void saveUserToken(UserRegistrationFormEntity entity, String jwtToken) {
        var token = Token.builder()
                .user(entity)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .dateTime(LocalDateTime.now())
                .build();
        tokenRepository.save(token);
        logger.debug("Token saved for user: {}", entity.getNickname());
    }
}

