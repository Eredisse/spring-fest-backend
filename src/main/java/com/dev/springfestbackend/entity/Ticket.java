package com.dev.springfestbackend.entity;

import com.dev.springfestbackend.enums.TicketTypeValues;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fest_tickets")
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TicketTypeValues ticketType;

    private boolean isAvailable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Long price;

    @Column(unique = true)
    private String ticketCode;

    public Ticket(TicketTypeValues ticketType, boolean isAvailable, Long price, String ticketCode) {
        this.ticketType = ticketType;
        this.isAvailable = isAvailable;
        this.price = price;
        this.ticketCode = ticketCode;
    }

}
