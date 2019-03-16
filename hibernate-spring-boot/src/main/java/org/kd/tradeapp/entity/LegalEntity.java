package org.kd.tradeapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRD_legal_entity")
public class LegalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    /*@Embedded
    Address address;
*/
    public long getId() {
        return id;
    }
}
