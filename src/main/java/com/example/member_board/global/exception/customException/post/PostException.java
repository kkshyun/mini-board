package com.example.member_board.global.exception.customException.post;

import com.example.member_board.global.exception.errorCode.CommonErrorCode;
import lombok.Getter;

@Getter
public class PostException extends RuntimeException {
    private final CommonErrorCode commonErrorCode;

    public PostException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.getMessage());
        this.commonErrorCode = commonErrorCode;
    }

}
