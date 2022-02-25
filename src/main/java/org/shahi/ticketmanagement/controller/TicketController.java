package org.shahi.ticketmanagement.controller;

import org.shahi.ticketmanagement.model.RestResponseDTO;
import org.shahi.ticketmanagement.model.Ticket;
import org.shahi.ticketmanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return tickets;
    }

    @GetMapping(value = "/statusCount")
    public ResponseEntity<?> countLoanStatus() {
        return new RestResponseDTO().successModel(ticketService.statusCount());
    }
}
