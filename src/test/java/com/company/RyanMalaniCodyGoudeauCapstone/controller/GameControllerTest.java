package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
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

public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    /*
    private int id;
    private String title;
    private String esrb_rating;
    private String description;
    private BigDecimal price;
    private String studio;
    private int quantity;
     */

    @Test
    public void shouldCreateGame() {

        // ARRANGE
        Game inputGame = new Game();
        inputGame.setTitle("Forza Horizon 5");
        inputGame.setEsrb_rating("Rated E");
        inputGame.setDescription("500GB");
        inputGame.setProcessor("AMD Jaguar");
        inputGame.setPrice("239.99");
        inputGame.setQuantity(1);

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
    public void shouldGetGameById() {
    }

    @Test
    public void shouldGetAllGames() {
    }

    @Test
    public void shouldGetGamesByStudio() {
    }

    @Test
    public void shouldGetGamesByEsrbRating() {
    }

    @Test
    public void shouldGetGamesByTitle() {
    }

    @Test
    public void shouldUpdateGame() {
    }

    @Test
    public void shouldDeleteGame() {
    }
}