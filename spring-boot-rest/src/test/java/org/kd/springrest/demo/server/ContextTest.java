package org.kd.springrest.demo.server;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.springrest.demo.server.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = {CountryDemoApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
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
