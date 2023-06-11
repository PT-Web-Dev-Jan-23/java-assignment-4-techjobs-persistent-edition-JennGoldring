package org.launchcode.techjobs.persistent.models;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Skill extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String description;
    @ManyToOne
    private Employer employer;

    public Skill () {
}

    public Integer getId(){
        return id;
    }
    public String getDescription() {
        return description;
}
    public void setDescription(String description) {
        this.description = description;
    }

    public Employer getEmployer() {
        return employer;
    }
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}