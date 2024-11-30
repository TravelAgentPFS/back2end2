package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.Policies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliciesRepository extends JpaRepository<Policies,Long> {
}
