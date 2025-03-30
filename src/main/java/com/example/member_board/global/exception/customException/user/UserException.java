package com.example.member_board.global.exception.customException.user;

import com.example.member_board.global.exception.errorCode.CommonErrorCode;
import lombok.Getter;

@Getter
//유저 관련 예외처리
public class UserException extends RuntimeException {
    private final CommonErrorCode errorCode;


    public UserException(CommonErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
