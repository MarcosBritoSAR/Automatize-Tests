package com.marcosbrito.compass.semana8.automatize_test.domain;

import static com.marcosbrito.compass.semana8.automatize_test.common.constantPlanet.PLANET;
import static org.mockito.Mockito.when;

import com.marcosbrito.compass.semana8.automatize_test.web.repository.PlanetRepository;
import com.marcosbrito.compass.semana8.automatize_test.web.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

}
