package org.shahi.ticketmanagement.controller;

import org.shahi.ticketmanagement.model.AuthenticationRequest;
import org.shahi.ticketmanagement.model.AuthenticationResponse;
import org.shahi.ticketmanagement.service.MyUserDetailsService;
import org.shahi.ticketmanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
public class TicketManagementController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping({"/hello"})
    public String hello() {
        return "<h1>Hello Worlddd</h1>";
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public String reserveTicket() {
        return "<h1>Reserve Ticket</h1>";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String paymentTicket() {
        return "<h1>Pay Ticket</h1>";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
