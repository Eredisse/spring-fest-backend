package com.dev.springfestbackend.entity;

import com.dev.springfestbackend.enums.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "fest_users")
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    public User(String name, String email, String password, UserRoles role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
