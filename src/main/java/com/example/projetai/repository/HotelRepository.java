package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
