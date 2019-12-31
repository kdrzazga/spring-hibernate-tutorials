package org.kd.springrest_integrate.server;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.kd.springboot.springrest.integrate.server.model.IntegralComputing;
import org.kd.springboot.springrest.integrate.server.model.WrongIntegralComputationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IntegralComputingTest {

    @DisplayName("Test estimation of integral value for given math function")
    @ParameterizedTest
    @ValueSource(strings = {"sin", "cos"})

    public void testEstimateIntegralValue(String methodName) {
        try {
            double integralValue1 = new IntegralComputing().estimateIntegralValue(methodName, 0.0, 2 * Math.PI, 1_000_000);
            assertEquals(0.0, integralValue1, 0.01);

            double integralValue2 = new IntegralComputing().estimateIntegralValue(methodName, 0.0, Math.PI / 2, 1_000_000);
            assertThat(integralValue2, greaterThan(Math.PI / 4));
            assertThat(integralValue2, lessThan(Math.PI / 2));
        }
        catch (WrongIntegralComputationException e){
            fail(e.getMessage());
        }
    }

    @DisplayName("Test estimation of integral value for given math function with multiplier and constant")
    @ParameterizedTest
    @ValueSource(strings = {"sin", "cos"})

    public void testEstimateIntegralValueWithMultiplierAndConstant(String methodName) {
        try {
            double integralValue1 = new IntegralComputing().estimateIntegralValue(methodName, 1, -1, 0.0, 2 * Math.PI, 1_000_000);
            assertEquals(-1, integralValue1, 0.01);

            double integralValue2 = new IntegralComputing().estimateIntegralValue(methodName, 10, 10, 0.0, 2 * Math.PI, 1_000_000);
            //integral S(10 * (sin x + 10)) dx should be around 10.0 - same as S(10 * (cos x + 10)) dx
            assertThat(integralValue2, greaterThan(9.0));
            assertThat(integralValue2, lessThan(11.0));
        }
        catch (WrongIntegralComputationException e){
            fail(e.getMessage());
        }
    }

    @DisplayName("Integral -pi/4 pi/4 S( tan x ) dx should be around 0")
    @Test
    public void testTan(){
        try {
            double integralValue = new IntegralComputing().estimateIntegralValue("tan", -Math.PI/4, Math.PI/4, 1_000_000);
            assertEquals(0, integralValue, 0.01);
        }
        catch (WrongIntegralComputationException e){
            fail(e.getMessage());
        }
    }

}
