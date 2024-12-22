package com.marcosbrito.compass.semana8.automatize_test.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String climate;
    private String terrain;

    public Planet(String name, String climate, String terrain) {
        this.terrain = terrain;
        this.climate = climate;
        this.name = name;
    }
}
