package com.dev.springfestbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

}
