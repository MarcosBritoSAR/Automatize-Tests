package com.marcosbrito.compass.semana8.automatize_test.common;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;

public class PlanetConstants {
  public static final Planet PLANET = new Planet("name", "climate", "terrain");
  public static final Planet INVALID_PLANET = new Planet("", "", "");


}
