package com.example.demo2.controller;

import com.example.demo2.dto.PartDto;
import com.example.demo2.service.interfaces.PartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartController {

    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping(value = "find3analogs/{vendorCode}", method = RequestMethod.GET)
    @ResponseBody
    public List<PartDto> find3analogs(@RequestParam String vendorCode) {

        return partService.find3CheapAnalogs(vendorCode);
    }
}
