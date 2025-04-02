package com.example.member_board.controller;

import com.example.member_board.domain.Post;
import com.example.member_board.domain.User;
import com.example.member_board.dto.*;
import com.example.member_board.service.PostService;
import com.example.member_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<SuccessResponse<Post>> createPost(@RequestBody CreatePostRequest req) {
        Post post = postService.createPost(req);
        return ResponseEntity.ok(new SuccessResponse<>(200,"게시글 생성 성공",post));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Post>> getPostById(@PathVariable("id") Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(new SuccessResponse<>(200,"게시글 조회 성공",post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<Post>> updatePost(@PathVariable("id") Long id, @RequestBody UpdatePostRequest req) {
        Post post = postService.updatePost(id,req);
        return ResponseEntity.ok(new SuccessResponse<>(200,"게시글 업데이트 성공",post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<Post>> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok(new SuccessResponse<>(200,"게시글 삭제 성공",null));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<SuccessResponse<List<PostResponse>>> getAllPostsByUser(@PathVariable("userId") Long userId) {
        List<PostResponse> allPostsByUser = postService.getAllPostsByUser(userId);
        return ResponseEntity.ok(new SuccessResponse<>(200,"유저별 게시글 조회 성공",allPostsByUser));
    }
    @GetMapping
    public ResponseEntity<SuccessResponse<List<PostResponse>>> getAllPosts() {
        List<PostResponse> allPosts = postService.getAllPosts();
        return ResponseEntity.ok(new SuccessResponse<>(200,"모든 게시글 조회 성공",allPosts));
    }
}
