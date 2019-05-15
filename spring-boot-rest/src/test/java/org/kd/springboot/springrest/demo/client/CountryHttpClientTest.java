package org.kd.springboot.springrest.demo.client;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.kd.springboot.springrest.demo.server.CountryDemoApplication;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CountryHttpClientTest {

    private static byte countryCounter;

    @BeforeClass
    public static void setUp() {
        CountryDemoApplication.main(new String[0]);
    }

    @Before
    public void resetCountryCounter() {
        countryCounter = 0;
    }

    @Test
    public void testCountriesEndpoint() {

        var response = new CountryHttpClient().request("/countries");
        assertNotNull(response);

        assertEquals(200, response.statusCode());
        assertNotNull(response.headers());
        assertNotNull(response.body());
    }

    @Test
    public void testSingleCountryEndpoint() {
        var response = new CountryHttpClient().request("/country/0");
        assertNotNull(response);

        assertEquals(HttpStatus.OK.value(), response.statusCode());
        assertNotNull(response.headers());
        assertNotNull(response.body());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Poland", "Germany", "Chad"})
    public void testSingleCountryEndpointGetCountryName(String country) {
        var response = new CountryHttpClient().request("/country/" + String.valueOf(countryCounter));

        assertNotNull(response);
        assertThat(response.body(), containsString(country));
        countryCounter++;
    }

    @Test
    public void testGetPoland(){
        var response = new CountryHttpClient().request("/country/0");

        assertNotNull(response);
        assertThat(response.body(), containsString("Poland"));

    }

    @ParameterizedTest
    @ValueSource(strings = {"Warszawa", "Berlin", "Njamena"})
    public void testSingleCountryEndpointGetCountryCapital(String capital) {
        var endpoint = "/country/" + String.valueOf(countryCounter);
        var response = new CountryHttpClient().request(endpoint);

        assertNotNull(response);
        assertThat(response.body(), containsString(capital));
        countryCounter++;
    }

    @AfterClass
    public static void tearDown() {
        CountryDemoApplication.getContext().stop();
    }
}
