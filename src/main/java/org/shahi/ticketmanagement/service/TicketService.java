package org.shahi.ticketmanagement.service;

import org.shahi.ticketmanagement.model.Ticket;

import java.util.List;
import java.util.Map;

public interface TicketService {

    List<Ticket> getAllTickets(String username);

    Map<String,Integer> statusCount();
}
