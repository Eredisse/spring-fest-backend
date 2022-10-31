package com.dev.springfestbackend.service;

import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.entity.Ticket;
import com.dev.springfestbackend.repo.TicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepo ticketRepo;

    public void generateTickets(GenerateTicketsDTO generateTicketsDTO) {

        List<Ticket> generatedTickets = new ArrayList<>();

        for (int i=0; i< generateTicketsDTO.getNumberOfTickets(); i++) {
            generatedTickets.add(
                    new Ticket(generateTicketsDTO.getTicketType(),
                            true,
                            generateTicketsDTO.getPricePerTicket(),
                            UUID.randomUUID().toString()));
        }

        ticketRepo.saveAll(generatedTickets);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

}
