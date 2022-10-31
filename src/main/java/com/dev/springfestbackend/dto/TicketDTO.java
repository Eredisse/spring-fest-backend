package com.dev.springfestbackend.dto;

import com.dev.springfestbackend.enums.TicketTypeValues;
import lombok.Data;

@Data
public class TicketDTO {

    private TicketTypeValues ticketType;

    private Long price;

    private String ticketCode;

}
