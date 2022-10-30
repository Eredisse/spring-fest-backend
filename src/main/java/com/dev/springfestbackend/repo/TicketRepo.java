package com.dev.springfestbackend.repo;

import com.dev.springfestbackend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
