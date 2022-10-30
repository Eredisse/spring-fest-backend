package com.dev.springfestbackend.dto;

import com.dev.springfestbackend.enums.TicketTypeValues;
import lombok.Data;

@Data
public class GenerateTicketsDTO {

    private TicketTypeValues ticketType;

    private Long numberOfTickets;

    private Long pricePerTicket;

}
