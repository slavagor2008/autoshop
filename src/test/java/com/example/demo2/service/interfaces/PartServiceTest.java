package com.example.demo2.service.interfaces;

import com.example.demo2.entity.Part;
import com.example.demo2.service.PartService;
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

@ComponentScan("com.example.demo2")
@RunWith(SpringRunner.class)
@DataJpaTest
public class PartServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PartService partService;

    private Part part1, part2, part3, part4, part5, part6;
    private List<Part> analogsForPart2 = new ArrayList<Part>();
    private List<Part> analogsForPart1 = new ArrayList<Part>();

    @Before
    public void initialEntities() {

        part1 = new Part("part1");
        part1.setMark("BMW");
        part1.setAvailable(true);
        part1.setPrice(40.0);
        part1.setVendorCode("vc1");

        part2 = new Part("part2");
        part2.setMark("VW");
        part2.setAvailable(true);
        part2.setPrice(50.0);
        part2.setVendorCode("123");

        part3 = new Part("part3");
        part3.setMark("Renault");
        part3.setAvailable(true);
        part3.setPrice(60.0);
        part3.setVendorCode("re1");

        part4 = new Part("part4");
        part4.setMark("KIA");
        part4.setAvailable(true);
        part4.setPrice(70.0);
        part4.setVendorCode("k4-4");

        part5 = new Part("part5");
        part5.setMark("Mers");
        part5.setAvailable(true);
        part5.setPrice(80.0);
        part5.setVendorCode("p5");

        part6 = new Part("part6");
        part6.setMark("Peugeot");
        part6.setAvailable(true);
        part6.setPrice(90.0);
        part6.setVendorCode("p6");

        analogsForPart1.add(part6);
        analogsForPart1.add(part5);

        analogsForPart2.add(part1);
        analogsForPart2.add(part3);
        analogsForPart2.add(part4);

        part1.setAnalogs(analogsForPart1);
        part2.setAnalogs(analogsForPart2);

        entityManager.persist(part1);
        entityManager.persist(part2);
        entityManager.persist(part3);
        entityManager.persist(part4);
        entityManager.persist(part5);
        entityManager.persist(part6);

        entityManager.flush();
    }

    @Test
    public void find3CheapAnalogs() {

        List<Part> analogsOfPart2 = part2.getAnalogs();

        System.out.println("");
        System.out.println("************The first three cheapest analogues************");

        partService.find3CheapAnalogs("123").forEach(System.out::println);

        System.out.println("**********************************************************");
        System.out.println("");
//        assertEquals(partService.find3CheapAnalogs().size(), 4);

    }
}