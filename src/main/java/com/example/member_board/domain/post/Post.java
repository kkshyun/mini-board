package com.example.member_board.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public PostDto toDto() {
        return PostDto.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .updatedAt(updatedAt)
                .build();
    }

    public void update(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.updatedAt = LocalDateTime.now();
    }

}
