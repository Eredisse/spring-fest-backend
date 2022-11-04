package com.dev.springfestbackend.mapper;

import com.dev.springfestbackend.dto.UserDTO;
import com.dev.springfestbackend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserDTO userEntityToUserDto(User user);

    User userDtoToUserEntity(UserDTO userDTO);
}
