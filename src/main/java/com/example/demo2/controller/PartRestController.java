package com.example.demo2.controller;

import com.example.demo2.entity.Part;
import com.example.demo2.service.interfaces.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restpart")
public class PartRestController {

    @Autowired
    PartService partService;

    @GetMapping("/allparts")
    public List<Part> getAllParts(){


    }


}
