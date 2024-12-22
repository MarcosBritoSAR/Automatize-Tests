package com.marcosbrito.compass.semana8.automatize_test.common;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;

import java.util.Optional;

public class constantPlanet {

    public static final Planet PLANET = new Planet("Terra", "Umido", "fertil");
    public static final Planet INVALID_PLANET = new Planet("", "", "");
    public static final Optional<Planet> PLANET_OPTIONAL = Optional.of(PLANET);

}
