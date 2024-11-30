package com.example.projetai.repository;

import com.example.projetai.entities.Activity;
import com.example.projetai.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
