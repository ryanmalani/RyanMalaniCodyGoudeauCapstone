package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.ConsoleInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
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
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Console> consoleList;

    @MockBean
    private ServiceLayer serviceLayer;

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

    // testing POST /consoles

    @Test
    public void shouldCreateConsole() throws Exception {

        // ARRANGE

        Console inputConsole = new Console();
        inputConsole.setModel("Xbox One");
        inputConsole.setManufacturer("Microsoft");
        inputConsole.setMemory_amount("500GB");
        inputConsole.setProcessor("AMD Jaguar");
        inputConsole.setPrice(new BigDecimal("239.99"));
        inputConsole.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputConsole);

//        Console outputConsole = new Console();
//        outputConsole.setModel("Xbox One");
//        outputConsole.setManufacturer("Microsoft");
//        outputConsole.setMemory_amount("500GB");
//        outputConsole.setProcessor("AMD Jaguar");
//        outputConsole.setPrice(new BigDecimal("239.99"));
//        outputConsole.setQuantity(1);
//        outputConsole.setId(2);
//
//        String outputJson = objectMapper.writeValueAsString(outputConsole);

        // ACT
        mockMvc.perform(
                post("/consoles") // perform post request
                        .content(inputJson)  // set request body
                        .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
        )
                .andDo(print())
                .andExpect(status().isCreated());
                //.andExpect(content().json(outputJson)); // ASSERT
    }

    @Test
    public void shouldGetConsoleById() throws Exception {

        // ARRANGE

        Console outputConsole = new Console();
        outputConsole.setModel("Xbox One");
        outputConsole.setManufacturer("Microsoft");
        outputConsole.setMemory_amount("500GB");
        outputConsole.setProcessor("AMD Jaguar");
        outputConsole.setPrice(new BigDecimal("239.99"));
        outputConsole.setQuantity(1);
        outputConsole.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputConsole);

        // ACT

        mockMvc.perform(get("/consoles/2")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /consoles

    @Test
    public void shouldGetAllConsoles() throws Exception {

        String outputJson = objectMapper.writeValueAsString(consoleList);

        mockMvc.perform(get("/consoles")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /consoles/{manufacturer}

    @Test
    public void shouldGetConsolesByManufacturer() throws Exception {

        // ARRANGE

        Console outputConsole = new Console();
        outputConsole.setModel("Xbox One");
        outputConsole.setManufacturer("Microsoft");
        outputConsole.setMemory_amount("500GB");
        outputConsole.setProcessor("AMD Jaguar");
        outputConsole.setPrice(new BigDecimal("239.99"));
        outputConsole.setQuantity(1);
        outputConsole.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputConsole);

        // ACT

        mockMvc.perform(get("/consoles/Microsoft")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing PUT /consoles/{id}

    @Test
    public void shouldUpdateConsole() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        // ARRANGE

        Console inputConsole = new Console();
        inputConsole.setModel("Xbox One");
        inputConsole.setManufacturer("Microsoft");
        inputConsole.setMemory_amount("500GB");
        inputConsole.setProcessor("AMD Jaguar");
        inputConsole.setPrice(new BigDecimal("259.99"));
        inputConsole.setQuantity(1);
        inputConsole.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputConsole);

        mockMvc.perform(
                        put("/consoles/2")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // testing DELETE /consoles/{id}

    @Test
    public void shouldDeleteConsole() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/consoles/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {

        // ARRANGE

        Console inputConsole = new Console();
        inputConsole.setModel("Xbox One");
        inputConsole.setMemory_amount("500GB");
        inputConsole.setProcessor("AMD Jaguar");
        inputConsole.setPrice(new BigDecimal("239.99"));
        inputConsole.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputConsole);

        // ACT

        mockMvc.perform(
                        post("/consoles")                                // perform the POST request
                                .content(inputJson)                         // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
                )
                .andDo(print())                                     // print results to console
                .andExpect(status().isUnprocessableEntity());                   // ASSERT (status code is 422)
    }

    @Test
    public void shouldReturn404StatusCodeIfRecordNotFound() throws Exception {

        mockMvc.perform(get("/consoles/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn422StatusCodeIfIdsDoNotMatch() throws Exception {

        // ARRANGE

        Console inputConsole = new Console();
        inputConsole.setModel("Xbox One");
        inputConsole.setManufacturer("Microsoft");
        inputConsole.setMemory_amount("500GB");
        inputConsole.setProcessor("AMD Jaguar");
        inputConsole.setPrice(new BigDecimal("239.99"));
        inputConsole.setQuantity(1);
        inputConsole.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputConsole);

        mockMvc.perform(
                        put("/consoles/5")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}