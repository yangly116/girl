package com.example.demo.controller;

import com.example.demo.domain.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private GirlController girlController;
    @Autowired
    private MockMvc mvc;
    private Logger logger = LoggerFactory.getLogger(GirlControllerTest.class);
    @Test
    public void girlList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}