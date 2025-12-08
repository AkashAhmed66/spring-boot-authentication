package com.example.user_management.mapper;

import com.example.user_management.dto.UserDto;
import com.example.user_management.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
