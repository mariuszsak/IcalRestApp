package com.ms.icalrestapp.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class HtmlControllerTest {

    private final String myServer = "http://localhost:8080/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnIndex() throws Exception {
        this.mockMvc.perform(get(myServer))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("index.html"));
    }
}