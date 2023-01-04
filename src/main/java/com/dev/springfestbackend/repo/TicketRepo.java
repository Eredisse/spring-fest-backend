package com.dev.springfestbackend.repo;

import com.dev.springfestbackend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    @Query( value = "select * from fest_tickets t " +
            "where t.ticket_type = :ticketType " +
            "and t.is_available = true limit 1", nativeQuery = true)
    Optional<Ticket> getFirstAvailableTicketByType(String ticketType);
}
