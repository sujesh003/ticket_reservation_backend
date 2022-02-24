package org.shahi.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class TicketController {

    @GetMapping("/tickets")
    public String getTickets() {
        return "<h1>Hello TIckers</h1>";
    }
}
