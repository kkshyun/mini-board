package com.example.member_board.domain.user;

import com.example.member_board.global.exception.customException.user.UserException;
import com.example.member_board.global.exception.errorCode.CommonErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByUserId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException(CommonErrorCode.USER_NOT_FOUND));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, User user) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new UserException(CommonErrorCode.USER_NOT_FOUND));
        findUser.update(user);
    }
}
