package com.example.demo2.entity;

import com.example.demo2.entity.interfaces.IDeliveryTime;

import javax.persistence.*;

@Entity
@Table(name = "delivery_time")
public class DeliveryTime implements IDeliveryTime {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private int deliveryTime;

    @ManyToOne(targetEntity = com.example.demo2.entity.Shop.class)
    private Shop shop;

    @ManyToOne(targetEntity = com.example.demo2.entity.Storage.class)
    private Storage storage;

    @Override
    public long getId() {
        return Id;
    }

    @Override
    public int getDeliveryTime() {
        return deliveryTime;
    }

    @Override
    public Shop getShop() {
        return shop;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }
}
