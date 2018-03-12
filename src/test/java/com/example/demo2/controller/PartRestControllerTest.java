package com.example.demo2.controller;

import com.example.demo2.dto.PartDto;
import com.example.demo2.entity.Part;
import com.example.demo2.service.PartService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@WebMvcTest(PartRestController.class)
public class PartRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartService partService;

    @Test
    public void givenParts_whenGetParts_thenReturnJsonArray() throws Exception{

        Part part = new Part("grm");

        List <Part> allParts = Arrays.asList(part);

        given(partService.getAllParts()).willReturn(allParts);

        mockMvc.perform(get("/restpart/allparts").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(1))).
                andExpect(jsonPath("$[0].name", is(part.getName())));
    }
}