package org.kd.springrest.demo.server.repository;

import org.kd.springrest.demo.server.model.Capital;
import org.kd.springrest.demo.server.model.Country;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CountryRepository {

    public List<Country> getAll() {
        return Arrays.asList(
                new Country("Poland", new Capital("Warszawa")),
                new Country("Germany", new Capital("Berlin")),
                new Country("Chad", new Capital("Njamena"))
                );
    }
}
