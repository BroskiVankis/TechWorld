package com.example.techworld.model.mapper;

import com.example.techworld.model.dto.user.UserRegisterDTO;
import com.example.techworld.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);
}
