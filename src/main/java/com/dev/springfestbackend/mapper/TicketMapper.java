package com.dev.springfestbackend.mapper;

import com.dev.springfestbackend.dto.TicketDTO;
import com.dev.springfestbackend.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TicketMapper {

    TicketDTO ticketEntityToTicketDto(Ticket ticket);
}
