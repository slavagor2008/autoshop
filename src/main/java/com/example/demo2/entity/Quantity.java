package com.example.demo2.entity;

import com.example.demo2.entity.interfaces.IQuantity;

import javax.persistence.*;

@Entity
@Table(name = "quantity")
public class Quantity implements IQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = com.example.demo2.entity.Storage.class)
    private Storage storage;

    @ManyToOne(targetEntity = com.example.demo2.entity.Part.class)
    private Part part;

    private int quantity;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }

    @Override
    public Part getPart() {
        return part;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
