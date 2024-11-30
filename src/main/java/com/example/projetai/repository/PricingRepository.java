package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<Pricing,Long> {
}
