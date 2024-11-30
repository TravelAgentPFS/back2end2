package com.example.projetai.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departureIataCode;
    private String departureTerminal;
    private LocalDateTime departureTime;
    private String arrivalIataCode;
    private String arrivalTerminal;
    private LocalDateTime arrivalTime;
    private String carrier;
    private String flightNumber;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
