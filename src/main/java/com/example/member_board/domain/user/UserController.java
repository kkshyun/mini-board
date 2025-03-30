package com.example.member_board.domain.user;

import com.example.member_board.global.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{userId}")
    public DataResponse<UserDto> getUserByUserId(@PathVariable("userId") Long userId) {
        User user = userService.getUserByUserId(userId);
        UserDto userDto = UserDto.of(user);
        return DataResponse.ok(userDto);
    }

    @PostMapping("/user")
    public DataResponse<UserDto> createUser(@RequestBody UserRequest userRequest) {
        User user = userRequest.toEntity();
        User savedUser = userService.createUser(user);
        UserDto userDto = UserDto.of(savedUser);
        return DataResponse.ok(userDto);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UserRequest userRequest) {
        userService.updateUser(userId, userRequest);
    }

}
