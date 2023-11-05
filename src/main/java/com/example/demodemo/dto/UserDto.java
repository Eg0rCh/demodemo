package com.example.demodemo.dto;

import com.example.demodemo.token.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String nickname;
    private String email;
    private String password;
    private List<Token> tokens;

}
