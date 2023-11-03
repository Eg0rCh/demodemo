package com.example.demodemo.repository;

import com.example.demodemo.entity.UserRegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationFormRepository extends JpaRepository<UserRegistrationFormEntity, Long> {

    public UserRegistrationFormEntity getUserRegistrationFormEntityByNickname(String nickname);
    public UserRegistrationFormEntity getUserRegistrationFormEntityByEmail(String email);
}
