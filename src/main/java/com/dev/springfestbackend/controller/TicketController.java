package com.dev.springfestbackend.controller;

import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/generate")
    public HttpStatus generateTickets(@RequestBody GenerateTicketsDTO generateTicketsDTO) {
        ticketService.generateTickets(generateTicketsDTO);
        return HttpStatus.OK;
    }

}
