package com.example.user_management.dto;

import com.example.user_management.entity.Role;

import java.util.Set;

public record UserDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        Set<Role> roles
) {

}
