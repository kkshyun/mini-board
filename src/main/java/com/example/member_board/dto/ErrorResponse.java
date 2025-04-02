package com.example.member_board.dto;


import java.time.LocalDateTime;

public record ErrorResponse(int status, String message, LocalDateTime timeStamp) {

}
