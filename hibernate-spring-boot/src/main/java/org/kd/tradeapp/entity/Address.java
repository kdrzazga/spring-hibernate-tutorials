package org.kd.tradeapp.entity;

/*@Embeddable
@Entity
@Table(name = "TRD_address")*/
public class Address {

    private String street;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
