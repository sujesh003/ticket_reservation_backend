package org.shahi.ticketmanagement.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.shahi.ticketmanagement.model.Ticket;
import org.shahi.ticketmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Log logger = LogFactory.getLog(TicketServiceImpl.class);


    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets;
    }

    @Override
    public Map<String, Integer> statusCount() {
        Map<String, Integer> status = ticketRepository.statusCount();

        status.entrySet().forEach(entry -> {
            System.out.println("here goes map " + entry.getKey() + " " + entry.getValue());
        });
        System.out.println("Statusstatus" + status);
        return status;
    }
}
