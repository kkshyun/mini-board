package com.example.member_board.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public void updatePost(Long id, Post post) {
        Post findPost = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        findPost.update(post);
    }

}
