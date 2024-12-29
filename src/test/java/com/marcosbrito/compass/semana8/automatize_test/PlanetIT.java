package com.marcosbrito.compass.semana8.automatize_test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static com.marcosbrito.compass.semana8.automatize_test.common.PlanetConstants.*;
import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;

@ActiveProfiles("it")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:delete-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Sql(scripts = "classpath:insert-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class PlanetIT {

/* 
 * Notas:
 * Os Scripts sql são importante para connfigurar o banco após ou antes de cada teste. 
 * Caso de uso: Em um banco onde eu não posso duplicar objetos, não é possivel testar o mesmo teste usando 
 * os mesmo parametros. Isso torna o teste frágil. Com isso em mente, podemos optar por escolher excluir
 * os dados smepre após o teste.
 */

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void createPlanet_returnCreated() {

        //act
        ResponseEntity<Planet> sut = restTemplate.postForEntity("/planets", PLANET, Planet.class);

        //assert
        assertEquals(sut.getStatusCode(), HttpStatus.CREATED);
        assertNotNull(sut.getBody().getId());
        assertEquals(sut.getBody().getName(), PLANET.getName());
        assertEquals(sut.getBody().getClimate(), PLANET.getClimate());
        assertEquals(sut.getBody().getTerrain(), PLANET.getTerrain());   
    }


    @Test
    public void createPlanet_returnPlanet() {

        //act
        ResponseEntity<Planet> sut = restTemplate.getForEntity("/planets/1", Planet.class);

        //assert
        assertEquals(sut.getStatusCode(), HttpStatus.OK);
        assertEquals(sut.getBody(), TATOOINE);   }

}
