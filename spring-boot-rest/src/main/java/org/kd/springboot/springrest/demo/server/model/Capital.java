package org.kd.springboot.springrest.demo.server.model;

public class Capital {
    private String name;

    public Capital() {
    }

    public Capital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Capital{" + "name='" + name + '\'' + '}';
    }
}
