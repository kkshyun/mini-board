package com.example.member_board.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class PostRequest {
    private String userId;

    private String title;

    private String content;

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
