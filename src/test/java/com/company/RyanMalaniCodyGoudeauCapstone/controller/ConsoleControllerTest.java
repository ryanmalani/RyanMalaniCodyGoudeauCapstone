package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    /*
    private int id;
    private String model;
    private String manufacturer;
    private String memory_amount;
    private String processor;
    private BigDecimal price;
    private int quantity;
     */

    @Test
    public void shouldCreateConsole() {

        // ARRANGE
        Console inputConsole = new Console();
        inputConsole.setModel("Xbox One");
        inputConsole.setManufacturer("Microsoft");
        inputConsole.setMemory_amount("500GB");
        inputConsole.setProcessor("AMD Jaguar");
        inputConsole.setPrice("239.99");
        inputConsole.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputConsole);

        // ACT
        mockMvc.perform(
                post("/consoles") // perform post request
                        .content(inputJson)  // set request body
                        .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetConsoleById() {
    }

    @Test
    public void shouldGetAllConsoles() {
    }

    @Test
    public void shouldGetConsolesByManufacturer() {
    }

    @Test
    public void shouldUpdateConsole() {
    }

    @Test
    public void shouldDeleteConsole() {
    }
}