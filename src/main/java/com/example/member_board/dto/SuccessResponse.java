package com.example.member_board.dto;

public record SuccessResponse<T>(int status, String message, T data) {
}
