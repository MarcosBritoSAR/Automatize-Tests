package com.marcosbrito.compass.semana8.automatize_test.domain;

import static com.marcosbrito.compass.semana8.automatize_test.common.constantPlanet.*;
import static org.mockito.Mockito.when;

import com.marcosbrito.compass.semana8.automatize_test.web.repository.PlanetRepository;
import com.marcosbrito.compass.semana8.automatize_test.web.service.PlanetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
//informa ao spring que isso aqui é uma classe de teste e que precisa do uso de Beans
public class PlanetServiceTest {
    /*
    Vou precisar testar minha unidade de teste service.
     */
    @InjectMocks //Cria uma instancia valida do objeto
    private PlanetService planetService;

    @Mock //Não tenho mais o contexto do Spring pra usar o @MockBean
    private PlanetRepository planetRepository;


    @Test
    public void createPlanet_WithDataValid_restr_returnsPlanet() {
// AAA

        //Arrange -> Arrumar os dados pro teste
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        //Act -> Pratico a ação de teste
        Planet sut = planetService.create(PLANET);

        //Assert -> Verifico o resutlado dos testes
        Assertions.assertEquals(PLANET, sut);

    }


    @Test
    public void createPlanet_WithDataInvalid_ThrowException() {

        //Arrange
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        //act
        //assert
        Assertions.assertThrows(RuntimeException.class, () -> planetService.create(INVALID_PLANET));

    }

    @Test

    public void createPlanet_WithExistPlanet_ThrowException() {

        //Arrange
        when(planetRepository.save(PLANET)).thenThrow(RuntimeException.class);

        //act
        //assert
        Assertions.assertThrows(RuntimeException.class, () -> planetService.create(INVALID_PLANET));

    }


    @Test
    public void getPlanet_WithExistentID_returnsPlanet() {

        //Arrange
        when(planetService.get(1L)).thenReturn(PLANET_OPTIONAL);
        //act

        Optional<Planet> obj = planetService.get(1L);

        //assert

        Assertions.assertEquals(PLANET, obj.get());

    }

    @Test
    public void getPlanet_ByUnexistingID_returnEmpty() {

        when(planetService.get(2L)).thenReturn(null);

        Optional<Planet> obj = planetService.get(2L);

        Assertions.assertEquals(null, obj);
    }

    @Test
    public void listPlanet_ReturnsAllPlanets() {
        when(planetService.list(PLANET.getTerrain(), PLANET.getClimate())).thenReturn(new ArrayList<>(Arrays.asList(PLANET)));

        List<Planet> list = planetService.list(PLANET.getTerrain(), PLANET.getClimate());

        Assertions.assertEquals(list.size(), 1);
    }

    @Test
    public void listPlanet_ReturnsNoPlanets() {
        when(planetService.list(INVALID_PLANET.getTerrain(), INVALID_PLANET.getClimate())).thenReturn(new ArrayList<>());

        List<Planet> list = planetService.list(INVALID_PLANET.getTerrain(), INVALID_PLANET.getClimate());

        Assertions.assertEquals(list.size(), 0);
    }

}
