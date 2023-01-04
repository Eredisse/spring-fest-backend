package com.dev.springfestbackend.service;

import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.dto.TicketDTO;
import com.dev.springfestbackend.entity.Ticket;
import com.dev.springfestbackend.entity.User;
import com.dev.springfestbackend.enums.TicketTypeValues;
import com.dev.springfestbackend.mapper.TicketMapper;
import com.dev.springfestbackend.repo.TicketRepo;
import com.dev.springfestbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepo ticketRepo;

    private final TicketMapper ticketMapper;

    private final UserRepo userRepo;

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

    public TicketDTO buyTicketByUser(Long userId, TicketTypeValues ticketType) {
        User currentUser = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Ticket ticket = ticketRepo.getFirstAvailableTicketByType(ticketType.toString())
                .orElseThrow(() -> new RuntimeException("No ticket available"));
        ticket.setAvailable(false);
        ticket.setUser(currentUser);
        ticketRepo.save(ticket);
        return ticketMapper.ticketEntityToTicketDto(ticket);
    }

}
