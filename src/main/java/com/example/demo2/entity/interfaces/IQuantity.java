package com.example.demo2.entity.interfaces;

import com.example.demo2.entity.Part;
import com.example.demo2.entity.Storage;

public interface IQuantity {

    long getId();

    Storage getStorage();

    Part getPart();

    int getQuantity();
}
