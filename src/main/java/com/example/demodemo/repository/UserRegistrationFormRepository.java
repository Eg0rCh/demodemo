package com.example.demodemo.repository;

import com.example.demodemo.entity.UserRegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRegistrationFormRepository extends JpaRepository<UserRegistrationFormEntity, Long> {

    Optional<UserRegistrationFormEntity> findById(Long Long);
    Optional<UserRegistrationFormEntity>findByEmail(String email);
}
