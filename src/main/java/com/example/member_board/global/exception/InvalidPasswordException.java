package com.example.member_board.global.exception;

public class InvalidPasswordException extends IllegalArgumentException{

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException() {
        super("이메일 또는 비밀번호가 일치하지 않습니다.");
    }
}
