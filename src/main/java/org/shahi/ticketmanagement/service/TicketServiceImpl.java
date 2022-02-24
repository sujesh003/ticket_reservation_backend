package org.shahi.ticketmanagement.service;

import org.shahi.ticketmanagement.model.Ticket;
import org.shahi.ticketmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets;
    }
}
