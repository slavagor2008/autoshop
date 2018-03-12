package com.example.demo2.service.interfaces;

import com.example.demo2.dto.PartDto;
import com.example.demo2.entity.Part;

import java.util.List;

public interface IPartService {

    List<PartDto> find3CheapAnalogs(String vendorCode);

    List<Part> getAllParts();

}
