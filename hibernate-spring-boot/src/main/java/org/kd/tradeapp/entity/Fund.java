package org.kd.tradeapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRD_funds")
@PrimaryKeyJoinColumn(name = "party_id", referencedColumnName = "id")
public class Fund{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortname;
    private String name;
    private float units;

    @JoinTable(
            name = "TRD_funds_available4party",
            joinColumns = @JoinColumn(
                    name = "fund_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "party_id",
                    referencedColumnName = "id"
            )
    )
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    //@JoinColumn(name = "party_id")
    private Party party;

    Fund() {
    }

    public Fund(String shortname, String name, float units, Party party) {
        this.shortname = shortname;
        this.name = name;
        this.units = units;
        this.party = party;
    }

    public void setId(Long id) {
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

    public Long getId() {
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

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Fund " + getId() + " " + getShortname() + " " + getName() + " with units: " + getUnits();
    }
}
