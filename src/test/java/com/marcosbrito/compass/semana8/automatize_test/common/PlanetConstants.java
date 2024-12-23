package com.marcosbrito.compass.semana8.automatize_test.common;

import com.marcosbrito.compass.semana8.automatize_test.domain.Planet;

public class PlanetConstants {

  private PlanetConstants() {
  }
  public static final Planet PLANET = new Planet("name", "climate", "terrain");
  public static final Planet INVALID_PLANET_STRING_INVALID = new Planet("", "", "");
  public static final Planet INVALID_PLANET_NULLC_CONSTRUCT = new Planet();

  public static final Planet TATOOINE = new Planet(1L, "Tatooine", "arid", "desert");
  
  public static final Planet ALDERAAN = new Planet(2L, "Alderaan", "temperate", "grasslands, mountains");
  public static final Planet YAVIN_IV = new Planet(3L, "Yavin IV", "temperate, tropical", "jungle, rainforests");
  public static final Planet HOTH = new Planet(4L, "Hoth", "frozen", "tundra, ice caves, mountain ranges");
  public static final Planet DAGOBAH = new Planet(5L, "Dagobah", "murky", "swamp, jungles");
  public static final Planet BESPIN = new Planet(6L, "Bespin", "temperate", "gas giant");
  public static final Planet ENDOR = new Planet(7L, "Endor", "temperate", "forests, mountains, lakes");
  public static final Planet NABOO = new Planet(8L, "Naboo", "temperate", "grassy hills, swamps, forests");
  public static final Planet CORUSCANT = new Planet(9L, "Coruscant", "temperate", "cityscape, mountains");
  public static final Planet KAMINO = new Planet(10L, "Kamino", "temperate", "ocean");
  public static final Planet GEONOSIS = new Planet(11L, "Geonosis", "temperate, arid", "rock, desert, mountain, barren");
  public static final Planet UTAPAU = new Planet(12L, "Utapau", "temperate, arid, windy",
      "scrublands, savanna, canyons, sinkholes");
  public static final Planet MUSTAFAR = new Planet(13L, "Mustafar", "hot", "volcanoes, lava rivers, mountains, caves");
  public static final Planet KASHYYYK = new Planet(14L, "Kashyyyk", "tropical", "jungle, forests, lakes, rivers");
  public static final Planet POLIS_MASSA = new Planet(15L, "Polis Massa", "artificial temperate", "airless asteroid");
  public static final Planet MYGEETO = new Planet(16L, "Mygeeto", "frigid", "glaciers, mountains, ice canyons");
  public static final Planet FELUCIA = new Planet(17L, "Felucia", "hot, humid", "fungus forests");
  public static final Planet CATO_NEIMOIDIA = new Planet(18L, "Cato Neimoidia", "temperate, moist",
      "mountains, fields, forests, rock arches");
  public static final Planet SALEUCAMI = new Planet(19L, "Saleucami", "hot", "caves, desert, mountains, volcanoes");
  public static final Planet STEWJON = new Planet(20L, "Stewjon", "temperate", "grass");
  public static final Planet ERIADU = new Planet(21L, "Eriadu", "polluted", "polluted");
  public static final Planet CORELLIA = new Planet(22L, "Corellia", "temperate", "plains, urban, hills, forests");
  public static final Planet RODIA = new Planet(23L, "Rodia", "hot", "jungles, oceans, urban, swamps");
  public static final Planet NAL_HUTTA = new Planet(24L, "Nal Hutta", "temperate", "urban, oceans, swamps, bogs");

}
