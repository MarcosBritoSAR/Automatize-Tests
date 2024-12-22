package com.marcosbrito.compass.semana8.automatize_test.domain;

import static com.marcosbrito.compass.semana8.automatize_test.common.constantPlanet.PLANET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.marcosbrito.compass.semana8.automatize_test.web.repository.PlanetRepository;

/*
 * Nota commit: Iniciando um teste de integração com implementacao de um fake doble
 * 
 * - Vou usar o TestEntityManager para realizar um consulta no h2 simulando a cosulta no MySql com o JpaRepository
 * 
 * - Vou usar o @DataJpaTest realizar as injecoes de dependencias
 */

@DataJpaTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createPlanet_WithDataValid_returnsPlanet() {

        Planet planet = planetRepository.save(PLANET);

        Planet sut = testEntityManager.find(Planet.class, planet.getId());

        assertNotNull(sut);

        assertEquals(planet.getName(), sut.getName());
        assertEquals(planet.getClimate(), sut.getClimate());
        assertEquals(planet.getTerrain(), sut.getTerrain());

    }

    @Test
    public void createPlanet_WithDataInvalid_ThrowException() {

        Planet planetNull = new Planet();
        Planet PlanetIvalid = new Planet("", "", "");

        assertThrows(RuntimeException.class, () -> {
            planetRepository.save(planetNull);
            planetRepository.save(PlanetIvalid);
        });



    }


}
