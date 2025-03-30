package com.example.member_board.global.exception.errorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CommonErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "C001", "User not found"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "C002", "Unauthorized");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


}
