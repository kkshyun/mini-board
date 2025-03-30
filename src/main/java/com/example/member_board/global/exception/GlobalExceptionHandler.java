package com.example.member_board.global.exception;

import com.example.member_board.global.exception.customException.user.UserException;
import com.example.member_board.global.exception.errorCode.CommonErrorCode;
import com.example.member_board.global.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<Object> handleUserException(UserException e) {
        CommonErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(ErrorResponse.from(errorCode));
    }

}
