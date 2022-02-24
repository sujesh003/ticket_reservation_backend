package org.shahi.ticketmanagement.repository;

import org.shahi.ticketmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
