package com.example.demo2.controller;

import com.example.demo2.dto.PartDto;
import com.example.demo2.service.interfaces.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/part")
public class PartController {

    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping(value = "/find3analogs/{vendorCode}", method = RequestMethod.GET)
    @ResponseBody
    public List<PartDto> find3analogs(@PathVariable("vendorCode") String vendorCode) {

        return partService.find3CheapAnalogs(vendorCode);
    }

    @RequestMapping(value = "/find3analogs/hw", method = RequestMethod.GET)
    @ResponseBody
    public String helloworld() {

        return "Hello World";
    }
}
