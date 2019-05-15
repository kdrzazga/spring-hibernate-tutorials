package org.kd.springboot.springrest.demo.server.model;

public class Country {
    private String name;
    private Capital capital;

    private Country() {
    }

    public Country(String name, Capital capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                '}';
    }
}
