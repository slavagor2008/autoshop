package com.example.demo2.repository;

import com.example.demo2.entity.Employee;
import com.example.demo2.entity.Kit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitRepository extends JpaRepository<Kit, Long> {

    Kit findByName(String name);

}
