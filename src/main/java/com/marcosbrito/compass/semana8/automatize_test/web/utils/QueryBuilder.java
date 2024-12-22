package com.marcosbrito.compass.semana8.automatize_test.web.utils;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class QueryBuilder {
    public static Example<Planet> makeQuery(Planet planet) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues();
        return Example.of(planet, exampleMatcher);
    }
}
