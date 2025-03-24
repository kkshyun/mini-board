package com.example.member_board.global.exception;

public class PostNotFoundException extends IllegalArgumentException{
    public PostNotFoundException(String message) {
        super(message);
    }
    public PostNotFoundException() {
        super("게시글이 존재하지 않습니다.");
    }
}
