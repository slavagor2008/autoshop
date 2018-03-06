package com.example.demo2.entity;

import com.example.demo2.entity.interfaces.IStorage;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "storage")
public class Storage implements IStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    @OneToMany(mappedBy = "storage", targetEntity = com.example.demo2.entity.DeliveryTime.class)
    private List<DeliveryTime> deliveryTimes;

    @OneToMany(mappedBy = "storage", targetEntity = com.example.demo2.entity.Quantity.class)
    private List<Quantity> quantities;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public List<Quantity> getQuantity() {
        return quantities;
    }

    @Override
    public List<DeliveryTime> getDeliveryTimes() {
        return deliveryTimes;
    }

}
