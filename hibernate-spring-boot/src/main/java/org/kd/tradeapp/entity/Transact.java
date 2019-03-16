package org.kd.tradeapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRD_transact")
public class Transact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long src_fund_id;
    private Long dest_fund_id;
    private float units;
    private boolean internal;

    private Transact(){
    }

    public Transact(Long src_fund_id, Long dest_fund_id, float units, boolean internal){
        this.src_fund_id = src_fund_id;
        this.dest_fund_id = dest_fund_id;
        this.units = units;
        this.internal = internal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Transaction " + this.id + "from Fund " + getDest_fund_id() + " to party " + getSrc_fund_id();
    }

    public Long getDest_fund_id() {
        return dest_fund_id;
    }

    public void setDest_fund_id(Long dest_fund_id) {
        this.dest_fund_id = dest_fund_id;
    }

    public Long getSrc_fund_id() {
        return src_fund_id;
    }

    public void setSrc_fund_id(Long src_fund_id) {
        this.src_fund_id = src_fund_id;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }
}
