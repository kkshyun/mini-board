package com.example.member_board.domain.post;

import com.example.member_board.global.response.DataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/{postId}")
    @Operation(summary = "특정 게시글 1개 조회", description = "게시글 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시글 조회 성공"),
            @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    })
    public ResponseEntity<DataResponse<PostDto>> getPost(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        PostDto postDto = PostDto.of(post);

        return ResponseEntity.ok(DataResponse.ok(postDto));
    }

    @PostMapping("/post")
    @Operation(summary = "게시글 작성", description = "게시글 작성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시글 작성 성공"),
            @ApiResponse(responseCode = "404", description = "게시글 작성 실패")
    })
    public DataResponse<PostDto> createPost(@RequestBody PostRequest postRequest) {
        Post post = postRequest.toEntity();
        Post savedPost = postService.savePost(post);
        PostDto postDto = PostDto.of(savedPost);

        return DataResponse.ok(postDto);
    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @PutMapping("/post/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody PostRequest postRequest) {
        postService.updatePost(postId, postRequest);
    }



}
