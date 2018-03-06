package com.example.demo2.entity.interfaces;

import com.example.demo2.entity.DeliveryTime;

import java.util.List;

public interface IShop {

    long getId();

    String getAddress();

    List<DeliveryTime> getDeliveryTimes();
}
