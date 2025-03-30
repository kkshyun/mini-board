package com.example.member_board.global.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@RequiredArgsConstructor
public class DataResponse<T> {
    private final T data;
    private final String code;

    public static <T> DataResponse<T> ok(T data) {
        return new DataResponse<>(data);
    }

    private DataResponse(T data) {
        this.code = "200"; // 성공 코드
        this.data = data;
    }
}
