package com.example.member_board.dto;

import com.example.member_board.domain.Post;

public record PostResponse(Long postId, Long userId, String title, String content) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getUser().getId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
