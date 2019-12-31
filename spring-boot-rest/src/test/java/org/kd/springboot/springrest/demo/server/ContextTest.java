package org.kd.springboot.springrest.demo.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.springboot.springrest.demo.server.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {CountryDemoApplication.class})
@ExtendWith(SpringExtension.class)
public class ContextTest {

    @Autowired
    private RestTemplate countryRestTemplate;

    @Autowired
    private CountryService countryService;

    @Test
    public void testCountryServiceInjection() {
        assertNotNull(countryService);
    }

    @Test
    public void testRestTemplateInjection() {
        assertNotNull(countryRestTemplate);
    }

}
