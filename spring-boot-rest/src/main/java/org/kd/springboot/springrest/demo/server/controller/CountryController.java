package org.kd.springboot.springrest.demo.server.controller;

import org.kd.springboot.springrest.demo.server.model.Country;
import org.kd.springboot.springrest.demo.server.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController extends Controller{

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> getAll() {
        return countryRepository.getAll();
    }

    @GetMapping("/country/{countryId}")
    public Country getOneCountry(@PathVariable String countryId) {
        return countryRepository.getAll().get(Integer.valueOf(countryId));
    }

}
