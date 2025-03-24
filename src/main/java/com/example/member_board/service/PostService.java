package com.example.member_board.service;

import com.example.member_board.domain.Post;
import com.example.member_board.domain.User;
import com.example.member_board.dto.*;

public interface PostService {
    public Post createPost(CreatePostRequest createPostRequest);
    public Post getPostById(Long id);
    public Post updatePost(Long id, UpdatePostRequest updatePostRequest);
    public void deletePost(Long id);
}
