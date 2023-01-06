package com.dev.springfestbackend.integration.service;

import com.dev.springfestbackend.ContainerBaseTest;
import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.dto.TicketDTO;
import com.dev.springfestbackend.entity.Ticket;
import com.dev.springfestbackend.entity.User;
import com.dev.springfestbackend.enums.TicketTypeValues;
import com.dev.springfestbackend.enums.UserRoles;
import com.dev.springfestbackend.repo.TicketRepo;
import com.dev.springfestbackend.repo.UserRepo;
import com.dev.springfestbackend.service.TicketService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketServiceTest extends ContainerBaseTest{

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    void generateTicketsTest() {
        GenerateTicketsDTO dto = new GenerateTicketsDTO
                (TicketTypeValues.EARLY_BIRD, 50L, 20L);
        ticketService.generateTickets(dto);
        Assertions.assertThat(ticketRepo.findAll()).hasSize(50);
    }

    @Test
    @Order(2)
    void givenUser_whenUserBuysTicket_ticketIsSold() {
        User user = new User("User de test", "user@gmail.com", "pArO1AStr0nG", UserRoles.USER);
        User saved_user = userRepo.save(user);
        TicketDTO soldTicket = ticketService.buyTicketByUser(saved_user.getId(),
                TicketTypeValues.EARLY_BIRD);
        Ticket ticket = ticketRepo.findByTicketCode(soldTicket.getTicketCode());
        Assertions.assertThat(ticket).isNotNull();
        Assertions.assertThat(ticket.getUser().getId()).isEqualTo(saved_user.getId());
        Assertions.assertThat(ticket.isAvailable()).isFalse();
    }


}
