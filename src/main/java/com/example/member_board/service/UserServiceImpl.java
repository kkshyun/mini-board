package com.example.member_board.service;

import com.example.member_board.domain.User;
import com.example.member_board.dto.CreateUserRequest;
import com.example.member_board.dto.LogInUserRequest;
import com.example.member_board.dto.UpdateUserRequest;
import com.example.member_board.global.exception.InvalidPasswordException;
import com.example.member_board.global.exception.UserNotFoundException;
import com.example.member_board.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        return userRepository.save(createUserRequest.toEntity());
    }

    @Override
    public User logIn(LogInUserRequest logInUserRequest) {
        User user = userRepository.findByEmail(logInUserRequest.email())
                .orElseThrow(() -> new InvalidPasswordException());
        if(user.getPassword().equals(logInUserRequest.password()))
            return user;
        else
            throw new InvalidPasswordException();
    }



    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
        return user;
    }

    @Transactional
    @Override
    public User updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
        user.update(updateUserRequest.username(),updateUserRequest.email(), updateUserRequest.password());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
        userRepository.delete(user);
    }
}
