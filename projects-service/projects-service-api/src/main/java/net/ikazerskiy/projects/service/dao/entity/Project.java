package net.ikazerskiy.projects.service.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "projects")
public class Project extends CommonEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
