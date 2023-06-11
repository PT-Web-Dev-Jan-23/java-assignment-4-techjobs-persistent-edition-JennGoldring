package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
@Entity
public class Skill extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
   private String id;

    @NotBlank
    private String description;

    public Skill () {
}
    public String getDescription() {
        return description;
}
    public void setDescription(String description) {
        this.description = description;
    }
}