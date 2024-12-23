package com.marcosbrito.compass.semana8.automatize_test.web;

import static com.marcosbrito.compass.semana8.automatize_test.common.PlanetConstants.INVALID_PLANET_NULLC_CONSTRUCT;
import static com.marcosbrito.compass.semana8.automatize_test.common.PlanetConstants.INVALID_PLANET_STRING_INVALID;
import static com.marcosbrito.compass.semana8.automatize_test.common.PlanetConstants.PLANET;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;
import com.marcosbrito.compass.semana8.automatize_test.domain.PlanetService;

/*
 * Notas:
 * MockMvc -> Simula uma requisição HTTP
 * ObjectMapper -> Converte objetos em JSON
 * static MockMvcRequestBuilders.post -> Cria uma requisição POST
 * static MockMvcResultMatchers.status -> Verifica o status da requisição
 * static MockMvcResultMatchers.jsonPath -> Verifica o corpo da resposta e usando .value() verifica se o valor é igual ao esperado4
 */

@WebMvcTest(PlanetController.class)
public class PlanetControllerTest {
    @Autowired
    private MockMvc webMvcTest;

    @Autowired
    private ObjectMapper objectMapper;

    // @InjectMocks -> O mockito injeta o mock da dependência
    @MockitoBean // Quando o Spring injeta o mock da dependencia
    private PlanetService planetService;

    @Test
    public void createPlanet_WithValidData_returnStatus201() throws Exception {

        when(planetService.create(PLANET)).thenReturn(PLANET);

        webMvcTest.perform(post("/planets")
                .content(objectMapper.writeValueAsString(PLANET)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(PLANET));

    }

    // o que acontece quando eu tento inserir dados invalidos

    @Test
    public void createPlanet_WithInvalidData_returnBadRequest() throws Exception {

        webMvcTest.perform(post("/planets")
                .content(objectMapper.writeValueAsString(INVALID_PLANET_STRING_INVALID))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity()); // isUnprocessableEntity() -> 422

        webMvcTest.perform(post("/planets")
                .content(objectMapper.writeValueAsString(INVALID_PLANET_NULLC_CONSTRUCT))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    public void createPlanet_WithExistinName_returnConflict() throws Exception {

        Planet planet = planetService.create(PLANET);

        when(planetService.create(any())).thenThrow(DataIntegrityViolationException.class);

        webMvcTest.perform(post("/planets")
                .content(objectMapper.writeValueAsString(PLANET))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());

    }
}
