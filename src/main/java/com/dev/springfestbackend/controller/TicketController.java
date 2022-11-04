package com.dev.springfestbackend.controller;

import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.entity.Ticket;
import com.dev.springfestbackend.enums.TicketTypeValues;
import com.dev.springfestbackend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/generate")
    public HttpStatus generateTickets(@RequestBody @Valid GenerateTicketsDTO generateTicketsDTO) {
        ticketService.generateTickets(generateTicketsDTO);
        return HttpStatus.OK;
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PutMapping("/buy/{userId}/{ticketType}")
    public Ticket buyTicket(@PathVariable("userId") Long userId,
                            @PathVariable("ticketType") TicketTypeValues ticketType) {

        return ticketService.buyTicketByUser(userId, ticketType);
    }

}
