package com.example.demo2.entity;

import com.example.demo2.entity.interfaces.IKit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kit")
public class Kit implements IKit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @ManyToMany(targetEntity=com.example.demo2.entity.Part.class)
    private List<Part> parts;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}