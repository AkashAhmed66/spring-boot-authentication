package com.example.user_management.mapper;

import com.example.user_management.dto.TableResponseDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface TableResponseMapper {
    public TableResponseDto toDto(Page<?> pageableData);
}
