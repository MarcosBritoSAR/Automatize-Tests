package com.marcosbrito.compass.semana8.automatize_test;

import com.marcosbrito.compass.semana8.automatize_test.Application.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    public void testRum() {
        Calculadora calculadora = new Calculadora();

        Function<List<Integer>, Integer> function = list -> {

            Integer results = 0;

            for (Integer integer : list) {
                results += integer;
            }
            return results;
        };

        //assert (calculadora.resultado_daLista_ePrimo(function));
        assertFalse(calculadora.resultado_daLista_ePrimo(function));
    }

}
