package com.example.demo2.entity.interfaces;

import com.example.demo2.entity.DeliveryTime;
import com.example.demo2.entity.Quantity;

import java.util.List;

public interface IStorage {

    long getId();

    String getAddress();

    List<Quantity> getQuantity();

    List<DeliveryTime> getDeliveryTimes();
}
