package com.example.demodemo.token;

import com.example.demodemo.entity.UserRegistrationFormEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="token")
public class Token {

    @Id
    @SequenceGenerator(name="tokenSequence", sequenceName="token_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tokenSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    public String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type")
    public TokenType tokenType = TokenType.BEARER;

    @Column(name = "expired")
    public boolean expired;

    @Column(name = "date_valid_to")
    public LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserRegistrationFormEntity user;

}




