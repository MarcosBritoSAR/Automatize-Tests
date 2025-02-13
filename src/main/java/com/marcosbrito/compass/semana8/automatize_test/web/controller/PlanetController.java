package com.marcosbrito.compass.semana8.automatize_test.web.controller;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;
import com.marcosbrito.compass.semana8.automatize_test.web.service.PlanetService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/planet")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @PostMapping
    public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) {
        Planet response = planetService.create(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Planet> getById(@PathVariable Long id) {
        return planetService.get(id).map(planet -> ResponseEntity.ok().body(planet)).orElse(ResponseEntity.notFound().build());
    }

}
