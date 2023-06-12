package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String description;

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs;

    public Skill () {
}

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    public int getId(){
        return id;
    }
    public String getDescription() {
        return description;
}
    public void setDescription(String description) {
        this.description = description;
    }

}