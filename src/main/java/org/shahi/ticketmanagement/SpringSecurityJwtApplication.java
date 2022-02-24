package org.shahi.ticketmanagement;

import org.shahi.ticketmanagement.model.Ticket;
import org.shahi.ticketmanagement.model.User;
import org.shahi.ticketmanagement.repository.TicketRepository;
import org.shahi.ticketmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityJwtApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @PostConstruct
    public void initializeUserAndTicket() {
        List<Ticket> tickets = new ArrayList<>();

        Ticket ticket1 = new Ticket();
        ticket1.setId(1);
        ticket1.setDescription("Movie Ticket");
        ticket1.setPrice(240.0);
        ticket1.setPayment(false);
        ticket1.setReserved(false);

        Ticket ticket2 = new Ticket();
        ticket2.setId(2);
        ticket2.setDescription("Heli Ticket");
        ticket2.setPrice(24000.0);
        ticket2.setPayment(false);
        ticket2.setReserved(false);

        Ticket ticket3 = new Ticket();
        ticket3.setId(3);
        ticket3.setDescription("Flight Ticket");
        ticket3.setPrice(180000.0);
        ticket3.setPayment(false);
        ticket3.setReserved(false);

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);

        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        user1.setId(1);
        user1.setActive(true);
        user1.setPassword("123456");
        user1.setUserName("Rojma");
        user1.setRoles("ROLE_ADMIN");

        user2.setId(2);
        user2.setActive(true);
        user2.setPassword("123456");
        user2.setUserName("Sujesh");
        user2.setRoles("ROLE_ADMIN");

        users.add(user1);
        users.add(user2);

        if (ticketRepository.count() == 0) {
            ticketRepository.saveAll(tickets);
        }

        if (userRepository.count() == 0) {
            userRepository.saveAll(users);
        }
    }

}
