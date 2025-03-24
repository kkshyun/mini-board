package com.example.member_board.controller;

import com.example.member_board.domain.User;
import com.example.member_board.dto.CreateUserRequest;
import com.example.member_board.dto.LogInUserRequest;
import com.example.member_board.dto.UpdateUserRequest;
import com.example.member_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest req) {
        return userService.createUser(req);
    }

    @PostMapping("/login")
    public User logIn(@RequestBody LogInUserRequest req) {
        return userService.logIn(req);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest req) {
        return userService.updateUser(id,req);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
