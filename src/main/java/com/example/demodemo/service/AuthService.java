package com.example.demodemo.service;

import com.example.demodemo.dto.RegistrationRequest;
import com.example.demodemo.dto.RegistrationResponse;
import com.example.demodemo.dto.UserDto;

public interface AuthService {
    public RegistrationResponse register(RegistrationRequest request); //mapper

}
