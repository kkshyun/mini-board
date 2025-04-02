package com.example.member_board.global.exception;

public class UserNotFoundException extends IllegalArgumentException{
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException() {
        super("사용자가 존재하지 않습니다.");
    }
}
