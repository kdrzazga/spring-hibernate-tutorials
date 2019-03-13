package org.kd.userapp.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NaturalId
    String pesel;

    private String name;

    private String role;

    protected User(){
    }

    public User(String name, String role, String pesel) {
        super();
        this.name = name;
        this.role = role;
        this.pesel = pesel;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
    }

}
