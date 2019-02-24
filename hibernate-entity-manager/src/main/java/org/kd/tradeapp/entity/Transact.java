package org.kd.tradeapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transact")
public class Transact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int party_id;
    private int dest_fund_id;
    private float units;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Transaction " + this.id + "from Fund " + getDest_fund_id() + " to party " + getParty_id();
    }

    public int getDest_fund_id() {
        return dest_fund_id;
    }

    public void setDest_fund_id(int dest_fund_id) {
        this.dest_fund_id = dest_fund_id;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }
}
