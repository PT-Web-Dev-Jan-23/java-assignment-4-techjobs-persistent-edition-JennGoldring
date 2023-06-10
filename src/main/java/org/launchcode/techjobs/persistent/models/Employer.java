package org.launchcode.techjobs.persistent.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Employer extends AbstractEntity {
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
