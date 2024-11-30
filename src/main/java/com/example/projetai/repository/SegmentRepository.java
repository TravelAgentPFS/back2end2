package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment,Long> {
}
