package com.example.demo2.service.interfaces;


import com.example.demo2.dto.PartDto;
import com.example.demo2.entity.Kit;
import com.example.demo2.entity.Part;
import com.example.demo2.repository.KitRepository;
import com.example.demo2.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PartService implements IPartService{

    private final PartRepository partRepository;
    private final KitRepository kitRepository;

    public PartService(PartRepository partRepository,
                       KitRepository kitRepository) {
        this.partRepository = partRepository;
        this.kitRepository = kitRepository;
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PartDto> find3CheapAnalogs(String vendorCode) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Part> query = cb.createQuery(Part.class);

        Root<Part> part = query.from(Part.class);
        Join<Part, Part> analogs = part.join("analogs");

        query.select(analogs).
                where(cb.equal(part.get("vendorCode"), vendorCode));
        query.orderBy(cb.asc(analogs.get("price")));

        List<Part> parts = entityManager.createQuery(query).setMaxResults(3).getResultList();

        List<PartDto> partsDto = new ArrayList<>();

        for (int i = 0; i < parts.size(); i++) {

            PartDto partDto = new PartDto();

            partDto.setId(parts.get(i).getId());
            partDto.setAvailable(parts.get(i).isAvailable());
            partDto.setMark(parts.get(i).getMark());
            partDto.setName(parts.get(i).getName());
            partDto.setPrice(parts.get(i).getPrice());
            partDto.setVendorCode(parts.get(i).getVendorCode());

            partsDto.add(partDto);
        }

        return partsDto;
    }
}
