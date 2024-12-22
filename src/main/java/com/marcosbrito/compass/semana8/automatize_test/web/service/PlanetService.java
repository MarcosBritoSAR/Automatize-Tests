package com.marcosbrito.compass.semana8.automatize_test.web.service;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;
import com.marcosbrito.compass.semana8.automatize_test.web.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public Planet create(Planet planet) {
        return planetRepository.save(planet);
    }

}
