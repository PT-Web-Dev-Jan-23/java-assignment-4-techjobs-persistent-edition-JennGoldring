package org.launchcode.techjobs.persistent.models;

import javax.validation.constraints.NotBlank;

@Entity
public class Skill extends AbstractEntity {
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