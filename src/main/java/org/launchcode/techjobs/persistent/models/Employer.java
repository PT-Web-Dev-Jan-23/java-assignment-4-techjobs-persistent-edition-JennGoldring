package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {


    @NotBlank
    @Size(max = 50)
    private String location;

    @OneToMany(mappedBy = "employer")
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs;
    public Employer() {
        jobs = new ArrayList<>();
        // no-arg constructor
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    @Override
    public Integer getId() {
        return super.getId();
    }
}