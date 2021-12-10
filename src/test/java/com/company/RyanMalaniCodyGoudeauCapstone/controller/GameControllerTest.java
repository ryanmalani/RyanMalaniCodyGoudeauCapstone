package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
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
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Game> gameList;

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
        inputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        inputGame.setPrice("55.99");
        inputGame.setStudio("Turn 10 Studios");
        inputGame.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputGame);

        Game outputGame = new Game();
        outputGame.setTitle("Forza Horizon 5");
        outputGame.setEsrb_rating("Rated E");
        outputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        outputGame.setPrice("55.99");
        outputGame.setStudio("Turn 10 Studios");
        outputGame.setQuantity(1);
        outputGame.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputGame);

        // ACT
        mockMvc.perform(
                        post("/games") // perform post request
                                .content(inputJson)  // set request body
                                .contentType(MediaType.APPLICATION_JSON)    // tell server it's json
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson)); // ASSERT
    }

    @Test
    public void shouldGetGameById() throws Exception {
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