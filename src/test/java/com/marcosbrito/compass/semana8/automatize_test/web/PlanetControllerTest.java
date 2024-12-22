package com.marcosbrito.compass.semana8.automatize_test.web;

import static com.marcosbrito.compass.semana8.automatize_test.common.PlanetConstants.PLANET;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
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

    @MockitoBean
    private PlanetService planetService;

    @Test
    public void createPlanet_WithValidData_returnStatus201() throws Exception {
        //Arrange
        when(planetService.create(PLANET)).thenReturn(PLANET);


        //Act e Assert
        webMvcTest.perform(post("/planets") // -> Cria uma requisição POST para a URL /planets
        .content(objectMapper.writeValueAsString(PLANET)).contentType(MediaType.APPLICATION_JSON)) // -> Converte o objeto PLANET em JSON
        .andExpect(status().isCreated()) // -> Verifica se o status da resposta é 201/created
        .andExpect(jsonPath("$").value(PLANET)); // -> Verifica se o corpo da resposta é igual ao objeto PLANET

        //Por que não é possivle separar as act das Asserts? O Eu preciso ingressar as expectativas junto com a requisição
        //Como apenas o mockMvc pode acessar a resposta, eu preciso verificar a resposta dentro do mockMvc 
    }
}

