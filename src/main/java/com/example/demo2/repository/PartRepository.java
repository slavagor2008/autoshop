package com.example.demo2.repository;

import com.example.demo2.entity.Employee;
import com.example.demo2.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long>{

    Part findById(long id);

    Part findByName(String name);

    Part findByVendorCode(String vendorCode);

}
