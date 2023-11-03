package com.example.demodemo.service;

import com.example.demodemo.entity.UserRegistrationFormEntity;
import com.example.demodemo.repository.UserRegistrationFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRegistrationFormRepository repository;

    @Override
    public String register(UserRegistrationFormEntity entity) {
        UserRegistrationFormEntity userByNickname = repository.getUserRegistrationFormEntityByNickname(entity.getNickname());
        if(!isNull(userByNickname)){
            throw new RuntimeException("Nickname already exist");
        }
        UserRegistrationFormEntity userByEmail = repository.getUserRegistrationFormEntityByEmail(entity.getEmail());
        if(!isNull(userByEmail)){
            throw new RuntimeException("Email already exist");
        }
        repository.save(entity);
        return "Registration complited";
    }
}
