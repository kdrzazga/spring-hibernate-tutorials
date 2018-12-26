package org.kd.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "funds")
public class Fund implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String shortname;
    private float units;
    private int party_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setUnits(float units) {
        this.units = units;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortname() {
        return shortname;
    }

    public float getUnits() {
        return units;
    }

    public int getParty_id() {
        return party_id;
    }

    @Override
    public String toString() {
        return "Fund " + getId() + " " + getShortname() + " " + getName() + " with units: " + getUnits();
    }
}
