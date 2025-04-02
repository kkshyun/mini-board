package com.example.member_board.dto;

import com.example.member_board.domain.User;

public record LogInUserRequest(String email, String password) {
}
