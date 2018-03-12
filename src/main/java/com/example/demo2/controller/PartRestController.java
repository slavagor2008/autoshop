package com.example.demo2.controller;

import com.example.demo2.dto.PartDto;
import com.example.demo2.entity.Part;
import com.example.demo2.repository.PartRepository;
import com.example.demo2.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/restpart")
public class PartRestController {

    @Autowired
    PartService partService;

    @GetMapping("/allparts")
    public List<Part> getAllParts(){

        return partService.getAllParts();
    }

    @RequestMapping(value = "/find3analogs/{vendorCode}", method = RequestMethod.GET)
    @ResponseBody
    public List<PartDto> find3analogs(@PathVariable("vendorCode") String vendorCode) {

        return partService.find3CheapAnalogs(vendorCode);
    }

    @GetMapping("/hw")
    public String helloworld(){

        return "Hello World";
    }
}
