package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

//    private String name;

    @ManyToOne
    private Employer employer;
    @ManyToMany
    private List<Skill> skills;

    public Job() {

    }

    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
