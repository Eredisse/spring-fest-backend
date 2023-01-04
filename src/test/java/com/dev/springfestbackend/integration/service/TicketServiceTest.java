package com.dev.springfestbackend.integration.service;

import com.dev.springfestbackend.ContainerBaseTest;
import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.enums.TicketTypeValues;
import com.dev.springfestbackend.repo.TicketRepo;
import com.dev.springfestbackend.service.TicketService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketServiceTest extends ContainerBaseTest{

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepo ticketRepo;

    @Test
    public void test() {
        GenerateTicketsDTO dto = new GenerateTicketsDTO
                (TicketTypeValues.EARLY_BIRD, 50L, 20L);
        ticketService.generateTickets(dto);

        Assertions.assertThat(ticketRepo.findAll()).hasSize(50);
    }

}
