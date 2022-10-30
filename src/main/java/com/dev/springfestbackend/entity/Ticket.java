package com.dev.springfestbackend.entity;

import com.dev.springfestbackend.enums.TicketTypeValues;

import javax.persistence.*;

@Entity
@Table(name = "fest_tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TicketTypeValues ticketType;

    private boolean isCanceled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Long price;

}
