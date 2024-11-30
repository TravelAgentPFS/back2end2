package com.example.projetai.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cityCode;
    private Double latitude;
    private Double longitude;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Room> rooms;
}
