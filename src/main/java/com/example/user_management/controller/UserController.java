package com.example.user_management.controller;

import com.example.user_management.dto.UserDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.service.implementation.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(savedUserDto);
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(
            @PathVariable Long id,
            @Valid @RequestBody UserDto userDto
            ) {
        UserDto responesUserDto = userService.updateUser(id, userDto);
        return ResponseEntity.ok(responesUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully !");
    }


}
