package org.shahi.ticketmanagement.controller;

import org.shahi.ticketmanagement.model.RestResponseDTO;
import org.shahi.ticketmanagement.model.Ticket;
import org.shahi.ticketmanagement.repository.UserRepository;
import org.shahi.ticketmanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<Ticket> tickets = ticketService.getAllTickets(username);
        return tickets;
    }

    @PostMapping("/save/ticket")
    public Ticket saveReservationandPaymentInformation(@RequestBody Ticket ticket) {
        return ticketService.saveTicketInformation(ticket);
    }

    @GetMapping(value = "/statusCount")
    public ResponseEntity<?> countLoanStatus() {
        return new RestResponseDTO().successModel(ticketService.statusCount());
    }
}
