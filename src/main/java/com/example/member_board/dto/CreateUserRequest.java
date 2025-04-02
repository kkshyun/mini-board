package com.example.member_board.dto;

import com.example.member_board.domain.User;

import java.time.LocalDateTime;

public record CreateUserRequest(String username, String email, String password) {
    public User toEntity() {
        return User.builder()
                .userName(username)
                .email(email)
                .password(password)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
