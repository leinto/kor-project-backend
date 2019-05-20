package com.kor.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="project_resources",
        joinColumns = {@JoinColumn(name="project_id")},
        inverseJoinColumns = {@JoinColumn(name="resource_id")})
    private Set<Resource> Resources = new HashSet<>();

    public Project() {
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the resources
     */
    public Set<Resource> getResources() {
        return Resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(Set<Resource> resources) {
        Resources = resources;
    }

    
}