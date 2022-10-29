package com.dev.springfestbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "fest_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String password;

    private String role;

}
