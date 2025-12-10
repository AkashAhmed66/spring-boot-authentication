package com.example.user_management.service;

import com.example.user_management.dto.UserDto;
import com.example.user_management.dto.UserResponseDto;

import java.util.List;

public interface UserServiceInterface {
    public UserDto createUser (UserDto userDto);
    public UserDto getUserById (Long id);
    public UserResponseDto getAllUsers();
    public UserDto updateUser(Long id, UserDto userDto);
    public void deleteUser(Long id);
}
