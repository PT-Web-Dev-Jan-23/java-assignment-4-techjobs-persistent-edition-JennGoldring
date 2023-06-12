package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

//    private String name;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToMany
    @JoinTable(
            name = "skill",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public Job() {
//        super();
        // no-arg constructor
    }

    public Job(String name, Employer employer, List<Skill> skills) {
//        super();
        this.name = name;
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
