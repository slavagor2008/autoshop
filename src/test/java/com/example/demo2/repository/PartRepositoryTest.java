package com.example.demo2.repository;

import com.example.demo2.entity.Part;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ComponentScan("com.example.demo2.repository")
@RunWith(SpringRunner.class)
@DataJpaTest
public class PartRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PartRepository partRepository;

    private Part part1, part2, part3;
    private List<Part> analogsForPart2 = new ArrayList<Part>();

    @Before
    public void initialEntities() {

        part1 = new Part("part1");
        part1.setMark("BMW");
        part1.setAvailable(true);
        part1.setPrice(2);
        part1.setVendorCode("vc1");

        part3 = new Part("part3");
        part3.setMark("Renault");
        part3.setAvailable(true);
        part3.setPrice(28.0);
        part3.setVendorCode("re1");

        part2 = new Part("part2");
        part2.setMark("VW");
        part2.setAvailable(true);
        part2.setPrice(50.0);
        part2.setVendorCode("123");

        analogsForPart2.add(part1);
        analogsForPart2.add(part3);

        part2.setAnalogs(analogsForPart2);

        entityManager.persist(part1);
        entityManager.persist(part2);
        entityManager.persist(part3);

        entityManager.flush();
    }

    @Test
    public void whenFindPartsAndKits() {

        Part foundPart = partRepository.findByName(part2.getName());
        assertEquals(part2.getAnalogs(), foundPart.getAnalogs());
    }
}