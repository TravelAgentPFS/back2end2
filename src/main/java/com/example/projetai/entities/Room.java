package com.example.projetai.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String bedType;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Pricing pricing;

    @OneToOne(cascade = CascadeType.ALL)
    private StayDetails stayDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private Policies policies;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
