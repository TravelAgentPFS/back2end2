package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
