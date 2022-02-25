package org.shahi.ticketmanagement.service;

import org.shahi.ticketmanagement.model.Ticket;
import org.shahi.ticketmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets(String username) {
        List<Ticket> tickets = ticketRepository.findAll();

        List<Ticket> selectedTickets = tickets
                .stream()
                .filter(t -> t.getUser().getUserName().equals(username))
                .collect(Collectors.toList());
        System.out.println("selected tickets" + selectedTickets);
        selectedTickets.forEach(ticket -> {
            System.out.println("ticket id" + ticket.getId());
            System.out.println("ticket id" + ticket.getDescription());
            System.out.println("ticket id" + ticket.getUser().getUserName());
        });
        return selectedTickets;
    }

    @Override
    public Map<String, Integer> statusCount() {
        Map<String, Integer> status = ticketRepository.statusCount();
        return status;
    }

    @Override
    public Ticket saveTicketInformation(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
