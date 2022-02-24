package org.shahi.springsecurityjwt.repository;

import org.shahi.springsecurityjwt.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
