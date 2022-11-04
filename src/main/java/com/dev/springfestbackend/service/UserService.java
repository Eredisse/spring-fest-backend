package com.dev.springfestbackend.service;

import com.dev.springfestbackend.dto.UserDTO;
import com.dev.springfestbackend.entity.User;
import com.dev.springfestbackend.enums.UserRoles;
import com.dev.springfestbackend.mapper.UserMapper;
import com.dev.springfestbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUserEntity(userDTO);
        user.setRole(UserRoles.USER);
        return userMapper
                .userEntityToUserDto(
                    userRepo.save(user));
    }
}
