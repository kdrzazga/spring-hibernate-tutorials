package org.kd.springboot.springrest.integrate.server.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class IntegralComputing {

    public double estimateIntegralValue(String function, double multiplier, double constant, double minX, double maxX, int precision)
            throws WrongIntegralComputationException {
        return constant + multiplier * estimateIntegralValue(function, minX, maxX, precision);
    }

    public double estimateIntegralValue(String function, double minX, double maxX, int precision)
            throws WrongIntegralComputationException {
        try {
            Optional<Method> method =
                    Arrays.stream(Class.forName("java.lang.Math")
                            .getDeclaredMethods())
                            .filter(functionMethod -> functionMethod.getName().equals(function))
                            .findFirst();

            if (method.isEmpty()) {
                throw new WrongIntegralComputationException("No function " + function);
            }

            double step = (maxX - minX) / precision;
            double finalValue = 0.0;

            for (double x = minX; x < maxX; x += step) {
                var value1 = (Double) method.get().invoke(null, new Double[]{x});
                var value2 = (Double) method.get().invoke(null, new Double[]{x});
                finalValue += step * value1 + step * (value2 - value1) / 2;
            }

            return finalValue;

        } catch (ClassCastException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            throw new WrongIntegralComputationException(e.getMessage());
        }

    }
}
