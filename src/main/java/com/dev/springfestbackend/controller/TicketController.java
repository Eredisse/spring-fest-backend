package com.dev.springfestbackend.controller;

import com.dev.springfestbackend.dto.GenerateTicketsDTO;
import com.dev.springfestbackend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> error = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            error.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
