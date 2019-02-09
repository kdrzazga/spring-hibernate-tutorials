package org.kd.hibernate.tradeapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transact")
public class Transact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int party_id;
    private int fund_id;
    private float units;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public int getFund_id() {
        return fund_id;
    }

    public void setFund_id(int fund_id) {
        this.fund_id = fund_id;
    }

    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Transaction " + this.id + "from Fund " + getFund_id() + " to party " + getParty_id();
    }
}
