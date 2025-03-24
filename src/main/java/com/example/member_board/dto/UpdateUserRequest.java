package com.example.member_board.dto;

import com.example.member_board.domain.User;

import java.time.LocalDateTime;

public record UpdateUserRequest(String username, String email, String password) {
}
