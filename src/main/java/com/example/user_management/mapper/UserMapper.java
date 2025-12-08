package com.example.user_management.mapper;

import com.example.user_management.dto.UserDto;
import com.example.user_management.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getFirstName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
    }

    public User toEntity(UserDto userDto) {
        return new User(
                userDto.id(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.email(),
                userDto.username(),
                userDto.password(),
                userDto.roles()
        );
    }
}
