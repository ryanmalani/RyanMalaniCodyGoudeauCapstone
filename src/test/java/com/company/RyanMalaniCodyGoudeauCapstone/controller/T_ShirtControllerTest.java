package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(T_ShirtController.class)
public class T_ShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ServiceLayer serviceLayer;

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

    // testing POST /t_shirts

    @Test
    public void shouldCreateT_Shirt() throws Exception {

        // ARRANGE
        T_Shirt inputT_Shirt = new T_Shirt();
        inputT_Shirt.setSize("S");
        inputT_Shirt.setColor("White");
        inputT_Shirt.setDescription("Plain White Tee");
        inputT_Shirt.setPrice(new BigDecimal("6.99"));
        inputT_Shirt.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputT_Shirt);

        // ACT
        mockMvc.perform(
                        post("/t_shirts") // perform post request
                                .content(inputJson)  // set request body
                                .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(inputJson)); // ASSERT
    }

    // testing GET /t_shirts/id/{id}

    @Test
    public void shouldGetT_ShirtById() throws Exception {

        // ARRANGE

        T_Shirt outputT_Shirt = new T_Shirt();
        outputT_Shirt.setSize("S");
        outputT_Shirt.setColor("White");
        outputT_Shirt.setDescription("Plain White Tee");
        outputT_Shirt.setPrice(new BigDecimal("6.99"));
        outputT_Shirt.setQuantity(1);
        outputT_Shirt.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputT_Shirt);

        // ACT

        mockMvc.perform(get("/t_shirts/id/2")) // perform get request
                        .andDo(print()) // print results to console
                        .andExpect(status().isOk()) // ASSERT status code is 200
                        .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /t_shirts

    @Test
    public void shouldGetAllT_Shirts() throws Exception{

        // ARRANGE

        T_Shirt outputT_Shirt = new T_Shirt();
        outputT_Shirt.setSize("S");
        outputT_Shirt.setColor("White");
        outputT_Shirt.setDescription("Plain White Tee");
        outputT_Shirt.setPrice(new BigDecimal("6.99"));
        outputT_Shirt.setQuantity(1);

        String outputJson = objectMapper.writeValueAsString(outputT_Shirt);

        // ACT

        mockMvc.perform(get("/t_shirts")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /t_shirts/color/{color}

    @Test
    public void shouldGetT_ShirtsByColor() throws Exception {

        // ARRANGE

        T_Shirt outputT_Shirt = new T_Shirt();
        outputT_Shirt.setSize("S");
        outputT_Shirt.setColor("White");
        outputT_Shirt.setDescription("Plain White Tee");
        outputT_Shirt.setPrice(new BigDecimal("6.99"));
        outputT_Shirt.setQuantity(1);
        outputT_Shirt.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputT_Shirt);

        // ACT

        mockMvc.perform(get("/t_shirts/color/White")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /t_shirts/size/{size}

    @Test
    public void shouldGetT_ShirtsBySize() throws Exception {

        // ARRANGE

        T_Shirt outputT_Shirt = new T_Shirt();
        outputT_Shirt.setSize("S");
        outputT_Shirt.setColor("White");
        outputT_Shirt.setDescription("Plain White Tee");
        outputT_Shirt.setPrice(new BigDecimal("6.99"));
        outputT_Shirt.setQuantity(1);
        outputT_Shirt.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputT_Shirt);

        // ACT

        mockMvc.perform(get("/t_shirts/size/S")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing PUT /t_shirts

    @Test
    public void shouldUpdateT_Shirt() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        // ARRANGE
        T_Shirt inputT_Shirt = new T_Shirt();
        inputT_Shirt.setSize("M");
        inputT_Shirt.setColor("White");
        inputT_Shirt.setDescription("Plain White Tee");
        inputT_Shirt.setPrice(new BigDecimal("6.99"));
        inputT_Shirt.setQuantity(1);
        inputT_Shirt.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputT_Shirt);

        mockMvc.perform(
                        put("/t_shirts/2")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteT_Shirt() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/records/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {
        // ARRANGE
        T_Shirt inputT_Shirt = new T_Shirt();
        inputT_Shirt.setColor("White");
        inputT_Shirt.setDescription("Plain White Tee");
        inputT_Shirt.setPrice(new BigDecimal("6.99"));
        inputT_Shirt.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputT_Shirt);

//        T_Shirt outputT_Shirt = new T_Shirt();
//        outputT_Shirt.setColor("White");
//        outputT_Shirt.setDescription("Plain White Tee");
//        outputT_Shirt.setPrice("6.99");
//        outputT_Shirt.setQuantity(1);
//        outputT_Shirt.setId(2);
//
//        String outputJson = objectMapper.writeValueAsString(outputT_Shirt);

        // ACT
        mockMvc.perform(
                        post("/t_shirts")                                // perform the POST request
                                .content(inputJson)                         // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
                )
                .andDo(print())                                     // print results to console
                .andExpect(status().isUnprocessableEntity());                   // ASSERT (status code is 422)
    }

    @Test
    public void shouldReturn404StatusCodeIfRecordNotFound() throws Exception {
        mockMvc.perform(get("/t_shirts/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn422StatusCodeIfIdsDoNotMatch() throws Exception {

        // ARRANGE
        T_Shirt inputT_Shirt = new T_Shirt();
        inputT_Shirt.setSize("S");
        inputT_Shirt.setColor("White");
        inputT_Shirt.setDescription("Plain White Tee");
        inputT_Shirt.setPrice(new BigDecimal("6.99"));
        inputT_Shirt.setQuantity(1);
        inputT_Shirt.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputT_Shirt);

        mockMvc.perform(
                        put("/t_shirts/5")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}