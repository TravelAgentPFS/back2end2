package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.StayDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayDetailsRepository extends JpaRepository<StayDetails,Long> {
}
