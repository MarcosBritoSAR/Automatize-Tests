package com.marcosbrito.compass.semana8.automatize_test.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Calculadora {

    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    public boolean resultado_daLista_ePrimo(Function<List<Integer>, Integer> function) {

        Integer sum = function.apply(list);

        for (int i = 2; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    return true;
            }
        }

        return false;
    }

}
