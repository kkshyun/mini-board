package com.example.member_board.controller;

import com.example.member_board.global.exception.InvalidPasswordException;
import com.example.member_board.global.exception.PostNotFoundException;
import com.example.member_board.global.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundExceptionHandler(UserNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String invalidPasswordExceptionHandler(InvalidPasswordException e){
        return e.getMessage();
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFoundExceptionHandler(PostNotFoundException e){
        return e.getMessage();
    }
}
