package com.example.projetai.service;

import com.example.projetai.entities.Flight;
import com.example.projetai.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;


    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        if (flightRepository.existsById(id)) {
            updatedFlight.setId(id);
            return flightRepository.save(updatedFlight);
        } else {
            throw new RuntimeException("Flight not found");
        }
    }

    public void deleteFlight(Long id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
        } else {
            throw new RuntimeException("Flight not found");
        }
    }
}
