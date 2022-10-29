package com.dev.springfestbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "fest_tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ticketType;

    private boolean isCanceled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
