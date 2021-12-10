package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(T_ShirtController.class)
public class T_ShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<T_Shirt> t_shirtList;

    @Before
    public void setUp() throws Exception {
    }

    /*
    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;
     */

    @Test
    public void shouldCreateT_Shirt() {

        // ARRANGE
        T_Shirt inputT_Shirt = new T_Shirt();
        inputT_Shirt.setSize("S");
        inputT_Shirt.setColor("White");
        inputT_Shirt.setDescription("Plain White Tee");
        inputT_Shirt.setPrice("6.99");
        inputT_Shirt.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputT_Shirt);

        T_Shirt outputT_Shirt = new T_Shirt();
        outputT_Shirt.setSize("S");
        outputT_Shirt.setColor("White");
        outputT_Shirt.setDescription("Plain White Tee");
        outputT_Shirt.setPrice("6.99");
        outputT_Shirt.setQuantity(1);
        outputT_Shirt.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputT_Shirt);

        // ACT
        mockMvc.perform(
                        post("/t_shirts") // perform post request
                                .content(inputJson)  // set request body
                                .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson)); // ASSERT
    }

    @Test
    public void shouldGetT_ShirtById() throws Exception {
    }

    @Test
    public void shouldGetAllT_Shirts() {
    }

    @Test
    public void shouldGetT_ShirtsByColor() {
    }

    @Test
    public void shouldGetT_ShirtsBySize() {
    }

    @Test
    public void shouldUpdateT_Shirt() {
    }

    @Test
    public void shouldDeleteT_Shirt() {
    }
}