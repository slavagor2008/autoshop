package com.example.demo2.entity.interfaces;

import com.example.demo2.entity.Kit;
import com.example.demo2.entity.Part;

import java.util.List;

public interface IPart {

    Long getId();

    String getName();

    String getVendorCode();

    double getPrice();

    List<Part> getAnalogs();

    String getMark();

    boolean isAvailable();

    void setAvailable(boolean available);

    List<Kit> getKits();
}
