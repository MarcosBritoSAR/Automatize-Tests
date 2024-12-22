package com.marcosbrito.compass.semana8.automatize_test.web.repository;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);
}
