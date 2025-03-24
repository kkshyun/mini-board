package com.example.member_board.dto;

import com.example.member_board.domain.Post;
import com.example.member_board.domain.User;

import java.time.LocalDateTime;

public record CreatePostRequest(Long userId, String title, String content) {
    public Post toEntity() {
        return Post.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
