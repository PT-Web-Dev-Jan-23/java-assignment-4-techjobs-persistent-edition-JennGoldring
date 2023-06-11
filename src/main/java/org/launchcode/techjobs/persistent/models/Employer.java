package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Entity
public class Employer extends AbstractEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String location;

    public Employer() {
        // no-arg constructor
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
