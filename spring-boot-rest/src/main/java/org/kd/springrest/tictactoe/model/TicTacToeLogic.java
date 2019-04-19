package org.kd.springrest.tictactoe.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class TicTacToeLogic {

    public double estimateIntegralValue(String function, double multiplier, double constant, double minX, double maxX, int precision) {
        return constant + multiplier * estimateIntegralValue(function, minX, maxX, precision);
    }

    public double estimateIntegralValue(String function, double minX, double maxX, int precision) {
        try {
            Optional<Method> method =
                    Arrays.stream(Class.forName("java.lang.Math")
                            .getDeclaredMethods())
                            .filter(functionMethod -> functionMethod.getName().equals(function))
                            .findFirst();


            double step = (maxX - minX) / precision;
            double finalValue = 0.0;

            for (double x = minX; x < maxX; x += step) {
                var value = (Double) method.get().invoke(null, new Double[]{x});
                finalValue += step * value;
            }

            return finalValue;

        } catch (ClassCastException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException("");
        }

    }
}
