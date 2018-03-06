package com.example.demo2.entity.interfaces;

import com.example.demo2.entity.Part;

import java.util.List;

public interface IKit {

    long getId();

    String getName();

    String getDescription();

    List<Part> getParts();
}
