package com.example.member_board.service;

import com.example.member_board.domain.Post;
import com.example.member_board.domain.User;
import com.example.member_board.dto.CreatePostRequest;
import com.example.member_board.dto.PostResponse;
import com.example.member_board.dto.UpdatePostRequest;
import com.example.member_board.global.exception.PostNotFoundException;
import com.example.member_board.global.exception.UserNotFoundException;
import com.example.member_board.repository.PostRepository;
import com.example.member_board.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Post createPost(CreatePostRequest createPostRequest) {
        User user = userRepository.findById(createPostRequest.userId()).orElseThrow(() -> new UserNotFoundException());
        return postRepository.save(createPostRequest.toEntity(user));
    }

    @Override
    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
        return post;
    }

    @Transactional
    @Override
    public Post updatePost(Long id, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
        post.update(updatePostRequest.title(), updatePostRequest.content());
        return post;
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
        postRepository.delete(post);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> allPostsByUserId = postRepository.findAll();
        return allPostsByUserId.stream()
                .map(PostResponse::from)
                .toList();
    }

    @Override
    public List<PostResponse> getAllPostsByUser(Long userId) {
        userRepository.findById(userId).orElseThrow(()->new UserNotFoundException());
        List<Post> allPostsByUserId = postRepository.findAllPostsByUserId(userId);
        return allPostsByUserId.stream()
                .map(PostResponse::from)
                .toList();
    }
}
