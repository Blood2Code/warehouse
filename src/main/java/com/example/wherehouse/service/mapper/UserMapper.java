package com.example.wherehouse.service.mapper;

import com.example.wherehouse.dto.UserDto;
import com.example.wherehouse.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
