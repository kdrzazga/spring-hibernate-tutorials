package org.kd.springboot.springrest.demo.server.service;

import org.kd.springboot.springrest.demo.server.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private RestTemplate countryRestTemplate;

    public List<Country> getAllCountries() {
        return Arrays.asList(countryRestTemplate.getForObject("/countries", Country[].class));
    }

    public Country getFirstCountry() {
        return countryRestTemplate.getForObject("/country/0", Country.class);
    }
}
