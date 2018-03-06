package com.example.demo2.entity.interfaces;

import com.example.demo2.entity.Shop;
import com.example.demo2.entity.Storage;

public interface IDeliveryTime {

    long getId();

    Shop getShop();

    Storage getStorage();

    int getDeliveryTime();
}
