package org.shahi.ticketmanagement.repository;

import org.shahi.ticketmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT "
            + "(SELECT  COUNT(payment) FROM ticket t"
            + "  WHERE t.payment  in (0)) PAID", nativeQuery = true)
    Map<String, Integer> statusCount();
}
