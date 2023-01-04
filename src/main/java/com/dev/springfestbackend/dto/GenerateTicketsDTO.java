package com.dev.springfestbackend.dto;

import com.dev.springfestbackend.enums.TicketTypeValues;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class GenerateTicketsDTO {

    private TicketTypeValues ticketType;

    @Positive @NotNull
    private Long numberOfTickets;

    @Positive @NotNull
    private Long pricePerTicket;

}
