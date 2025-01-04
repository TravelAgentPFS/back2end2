package com.example.projetai.controller;

import com.example.projetai.dto.FlightReservationRequest;
import com.example.projetai.entities.FlightReservation;
import com.example.projetai.service.FlightReservationService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flightReservations")
@CrossOrigin("*")
public class FlightReservationController {

    @Autowired
    private FlightReservationService flightReservationService;

    @PostMapping
    public FlightReservation createReservation(@RequestBody FlightReservationRequest request) throws StripeException {
        return flightReservationService.createReservation(request);
    }

    @GetMapping("/{userId}")
    public List<FlightReservation> getReservationsByUser(@PathVariable Long userId) {
        return flightReservationService.getReservationsByUser(userId);
    }


}
