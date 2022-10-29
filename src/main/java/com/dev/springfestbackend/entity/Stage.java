package com.dev.springfestbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "fest_stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String genre;
}
