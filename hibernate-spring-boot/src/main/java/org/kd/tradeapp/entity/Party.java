package org.kd.tradeapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TRD_parties")
public class Party{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<Fund> availableFunds;

    private String name;
    private String shortname;

    Party(){
    }

    public Party(String name, String shortname){
        this.name = name;
        this.shortname = shortname;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public List<Fund> getAvailableFunds() {
        return availableFunds;
    }

    @Override
    public String toString() {
        return "Party " + getId() + " " + getShortname() + " " + getName();
    }
}
