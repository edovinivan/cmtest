package com.example.cmtest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    void addValidUsers() throws Exception{
        MultiValueMap<String, String> listRole = new LinkedMultiValueMap<>();
        //listRole.add("1", "Admin");
        //listRole.add("3", "Manager");
        listRole.add("login", "test");
        listRole.add("name", "Test");
        listRole.add("password", "12345");


        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                //.param("login", "test")
                //.param("name", "Test")
                //.param("password", "12345"))
                .params(listRole))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());


    }

}