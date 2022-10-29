package com.dev.springfestbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "fest_signers")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

}
