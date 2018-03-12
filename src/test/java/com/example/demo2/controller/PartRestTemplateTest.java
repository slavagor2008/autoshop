package com.example.demo2.controller;


import com.example.demo2.dto.PartDto;
import com.example.demo2.entity.Part;
import com.example.demo2.repository.PartRepository;
import com.example.demo2.service.PartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartRestTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    PartService partService;

    @MockBean
    PartRepository partRepository;

    @MockBean
    PartRestController partRestController;

    private Part part1, part2, part3, part4, part5, part6, part7;
    private List<Part> analogsForPart2 = new ArrayList<Part>();
    private List<Part> analogsForPart1 = new ArrayList<Part>();

    @Test
    public void exampleTest() {
        String body = this.restTemplate.getForObject("/restpart/hw", String.class);
        assertThat(body).isEqualTo("Hello World");
    }

    @Test
    public void partRestTemplateTest() {

        Part part = new Part("p1");
        partRepository.save(part);
        System.out.println(partService.getAllParts());

        List<PartDto> body = this.restTemplate.getForObject("/restpart/find3analogs/123", List.class);

        assertThat(body).isEqualTo(partRestController.find3analogs("123"));


    }
}
