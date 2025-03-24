package com.example.member_board.controller;

import com.example.member_board.domain.Post;
import com.example.member_board.domain.User;
import com.example.member_board.dto.*;
import com.example.member_board.service.PostService;
import com.example.member_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestBody CreatePostRequest req) {
        return postService.createPost(req);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody UpdatePostRequest req) {
        return postService.updatePost(id,req);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}
