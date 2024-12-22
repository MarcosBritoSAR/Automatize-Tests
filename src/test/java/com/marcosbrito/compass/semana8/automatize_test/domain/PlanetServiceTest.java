package com.marcosbrito.compass.semana8.automatize_test.domain;

import static com.marcosbrito.compass.semana8.automatize_test.common.constantPlanet.PLANET;
import com.marcosbrito.compass.semana8.automatize_test.web.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PlanetService.class) //informa ao spring que isso aqui é uma classe de teste e que precisa do uso de Beans
@RequiredArgsConstructor
public class PlanetServiceTest {
    /*
    Vou precisar testar minha unidade de teste service.
     */
    private final PlanetService planetService;

@Test
    public void createPlanet_WithDataValid_restr_returnsPlanet(){

    //sut -> System Under Test
    /*
    Por padroes chamamos os nossos objeto de sut, que siguinifica
        - Sistema sobre testes
     */

    Planet sut = planetService.create(PLANET);

    Assertions.assertEquals(PLANET, sut);

    }

}
