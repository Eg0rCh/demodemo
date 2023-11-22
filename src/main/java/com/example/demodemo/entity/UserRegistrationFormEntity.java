package com.example.demodemo.entity;

import com.example.demodemo.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_info")
public class UserRegistrationFormEntity {

    @Id
    @SequenceGenerator(name="user_infoSequence", sequenceName="user_info_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_infoSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nick")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy ="user")
    private List<Token> tokens;
}


