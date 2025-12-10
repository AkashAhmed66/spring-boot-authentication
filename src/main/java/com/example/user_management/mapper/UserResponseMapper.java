package com.example.user_management.mapper;

import com.example.user_management.dto.UserDto;
import com.example.user_management.dto.UserResponseDto;
import com.example.user_management.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponseDto toDto(Page<User> pagedUser);
}
