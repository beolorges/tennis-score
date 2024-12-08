package com.ufmg.tennisscore.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "PracaEsportiva")
public class SportsSquare implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    @JoinColumn(name = "stadium_id", referencedColumnName = "id")
    private Stadium stadium;

    @OneToMany
    @JoinTable(
            name = "SportsSquare_Airports",
            joinColumns = @JoinColumn(name = "sports_square_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> nearbyAirports;

    @OneToMany
    @JoinTable(
            name = "SportsSquare_Hotels",
            joinColumns = @JoinColumn(name = "sports_square_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )
    private List<Hotel> nearbyHotels;
}
