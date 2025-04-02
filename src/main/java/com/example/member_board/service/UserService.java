package com.example.member_board.service;

import com.example.member_board.domain.User;
import com.example.member_board.dto.CreateUserRequest;
import com.example.member_board.dto.LogInUserRequest;
import com.example.member_board.dto.UpdateUserRequest;

import java.util.List;

public interface UserService {
    public User createUser(CreateUserRequest createUserRequest);
    public User logIn(LogInUserRequest logInUserRequest);
    public User getUserById(Long id);
    public User updateUser(Long id, UpdateUserRequest updateUserRequest);
    public void deleteUser(Long id);
}
