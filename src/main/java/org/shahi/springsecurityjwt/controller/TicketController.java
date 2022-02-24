package org.shahi.springsecurityjwt.controller;

import org.shahi.springsecurityjwt.model.Ticket;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/tickets"})
public class TicketController {

    private List<Ticket> tickets = createTickets();

    @CrossOrigin
    @GetMapping
    public List<Ticket> getTickets() {
        return null;
    }

    private static List<Ticket> createTickets() {
        List<Ticket> tickets = new ArrayList<>();
//        Ticket ticket1 = new Ticket();
//        ticket1.setId(1);
//        ticket1.setDescription("Movie Ticket");
//        ticket1.setPrice(240.0);
//        ticket1.setPayment(false);
//        ticket1.setReserved(false);
//
//        Ticket ticket2 = new Ticket();
//        ticket1.setId(2);
//        ticket1.setDescription("Movie Ticket");
//        ticket1.setPrice(240.0);
//        ticket1.setPayment(false);
//        ticket1.setReserved(false);
//        tickets.add(ticket1);
//        tickets.add(ticket2);
        return tickets;
    }
}
