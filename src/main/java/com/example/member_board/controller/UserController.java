package com.example.member_board.controller;

import com.example.member_board.domain.Post;
import com.example.member_board.domain.User;
import com.example.member_board.dto.CreateUserRequest;
import com.example.member_board.dto.LogInUserRequest;
import com.example.member_board.dto.SuccessResponse;
import com.example.member_board.dto.UpdateUserRequest;
import com.example.member_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<SuccessResponse<User>> createUser(@RequestBody CreateUserRequest req) {
        User user = userService.createUser(req);
        return ResponseEntity.ok(new SuccessResponse<>(200,"유저 생성 성공", user));
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse<User>> logIn(@RequestBody LogInUserRequest req) {
        User user = userService.logIn(req);
        return ResponseEntity.ok(new SuccessResponse<>(200,"유저 로그인 성공",user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<User>> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new SuccessResponse<>(200,"유저 조회 성공",user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<User>> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest req) {
        User user = userService.updateUser(id,req);
        return ResponseEntity.ok(new SuccessResponse<>(200,"유저 업데이트 성공",user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<User>> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new SuccessResponse<>(200,"유저 삭제 성공",null));
    }
}
