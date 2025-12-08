package com.example.user_management.service;

import com.example.user_management.dto.UserDto;

import java.util.List;

public interface UserServiceInterface {
    public UserDto createUser (UserDto userDto);
    public UserDto getUserById (Long id);
    public List<UserDto> getAllUsers();
    public UserDto updateUser(Long id, UserDto userDto);
    public void deleteUser(Long id);
}
