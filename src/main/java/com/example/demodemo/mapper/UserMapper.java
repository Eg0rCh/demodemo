package com.example.demodemo.mapper;

import com.example.demodemo.dto.UserDto;
import com.example.demodemo.entity.UserRegistrationFormEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserRegistrationFormEntity entity);
    UserRegistrationFormEntity toEntity(UserDto userDto);
}
