package com.example.demo2.entity;

import com.example.demo2.entity.interfaces.IShop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop implements IShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    @OneToMany(mappedBy = "shop", targetEntity = com.example.demo2.entity.DeliveryTime.class)
    private List<DeliveryTime> deliveryTimes;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public List<DeliveryTime> getDeliveryTimes() {
        return deliveryTimes;
    }
}
