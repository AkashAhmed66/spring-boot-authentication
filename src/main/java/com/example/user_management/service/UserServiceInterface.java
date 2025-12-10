package com.example.user_management.service;

import com.example.user_management.dto.TableResponseDto;
import com.example.user_management.dto.UserDto;
import org.springframework.data.domain.Pageable;

public interface UserServiceInterface {
    public UserDto createUser (UserDto userDto);
    public UserDto getUserById (Long id);
    public TableResponseDto getAllUsers(Pageable pageable);
    public UserDto updateUser(Long id, UserDto userDto);
    public void deleteUser(Long id);
}
