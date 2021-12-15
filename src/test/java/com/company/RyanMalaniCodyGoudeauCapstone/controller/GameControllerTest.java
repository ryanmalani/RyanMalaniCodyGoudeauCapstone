package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
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
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Game> gameList;

    @MockBean
    private ServiceLayer serviceLayer;

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

    // testing POST /games

    @Test
    public void shouldCreateGame() throws Exception {

        // ARRANGE

        Game inputGame = new Game();
        inputGame.setTitle("Forza Horizon 5");
        inputGame.setEsrb_rating("E");
        inputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        inputGame.setPrice(new BigDecimal("55.99"));
        inputGame.setStudio("Turn10");
        inputGame.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputGame);

        Game outputGame = new Game();
        outputGame.setTitle("Forza Horizon 5");
        outputGame.setEsrb_rating("E");
        outputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        outputGame.setPrice(new BigDecimal("55.99"));
        outputGame.setStudio("Turn10");
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

    // testing GET /games/{id}

    @Test
    public void shouldGetGameById() throws Exception {

        // ARRANGE

        Game outputGame = new Game();
        outputGame.setTitle("Forza Horizon 5");
        outputGame.setEsrb_rating("E");
        outputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        outputGame.setPrice(new BigDecimal("55.99"));
        outputGame.setStudio("Turn10");
        outputGame.setQuantity(1);
        outputGame.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputGame);

        // ACT

        mockMvc.perform(get("/games/2")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /games

    @Test
    public void shouldGetAllGames() throws Exception{

        String outputJson = objectMapper.writeValueAsString(gameList);

        mockMvc.perform(get("/games")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /games/{studio}

    @Test
    public void shouldGetGamesByStudio() throws Exception {

        // ARRANGE

        Game outputGame = new Game();
        outputGame.setTitle("Forza Horizon 5");
        outputGame.setEsrb_rating("E");
        outputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        outputGame.setPrice(new BigDecimal("55.99"));
        outputGame.setStudio("Turn10");
        outputGame.setQuantity(1);
        outputGame.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputGame);

        // ACT

        mockMvc.perform(get("/games/Turn10")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /games/{esrb_rating}

    @Test
    public void shouldGetGamesByEsrbRating() throws Exception {

        // ARRANGE

        Game outputGame = new Game();
        outputGame.setTitle("Forza Horizon 5");
        outputGame.setEsrb_rating("E");
        outputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        outputGame.setPrice(new BigDecimal("55.99"));
        outputGame.setStudio("Turn10");
        outputGame.setQuantity(1);
        outputGame.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputGame);

        // ACT

        mockMvc.perform(get("/games/E")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing GET /games/{title}

    @Test
    public void shouldGetGamesByTitle() throws Exception {

        // ARRANGE

        Game outputGame = new Game();
        outputGame.setTitle("Forza Horizon 5");
        outputGame.setEsrb_rating("E");
        outputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        outputGame.setPrice(new BigDecimal("55.99"));
        outputGame.setStudio("Turn10");
        outputGame.setQuantity(1);
        outputGame.setId(2);

        String outputJson = objectMapper.writeValueAsString(outputGame);

        // ACT

        mockMvc.perform(get("/games/Forza+Horizon+5")) // perform get request
                .andDo(print()) // print results to console
                .andExpect(status().isOk()) // ASSERT status code is 200
                .andExpect(content().json(outputJson)); // expect the object back
    }

    // testing PUT /games/{id}

    @Test
    public void shouldUpdateGame() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        // ARRANGE

        Game inputGame = new Game();
        inputGame.setTitle("Forza Horizon 5");
        inputGame.setEsrb_rating("E");
        inputGame.setDescription("Race cars around the city and battle your friends online.");
        inputGame.setPrice(new BigDecimal("55.99"));
        inputGame.setStudio("Turn10");
        inputGame.setQuantity(1);
        inputGame.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputGame);

        mockMvc.perform(
                        put("/games/2")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // testing DELETE /games/{id}

    @Test
    public void shouldDeleteGame() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/games/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {

        // ARRANGE

        Game inputGame = new Game();
        inputGame.setEsrb_rating("E");
        inputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        inputGame.setPrice(new BigDecimal("55.99"));
        inputGame.setStudio("Turn10");
        inputGame.setQuantity(1);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputGame);

        // ACT

        mockMvc.perform(
                        post("/games")                                // perform the POST request
                                .content(inputJson)                         // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
                )
                .andDo(print())                                     // print results to console
                .andExpect(status().isUnprocessableEntity());                   // ASSERT (status code is 422)
    }

    @Test
    public void shouldReturn404StatusCodeIfRecordNotFound() throws Exception {

        mockMvc.perform(get("/games/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn422StatusCodeIfIdsDoNotMatch() throws Exception {

        // ARRANGE

        Game inputGame = new Game();
        inputGame.setTitle("Forza Horizon 5");
        inputGame.setEsrb_rating("Rated E");
        inputGame.setDescription("Lead breathtaking expeditions across the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.");
        inputGame.setPrice(new BigDecimal("55.99"));
        inputGame.setStudio("Turn 10 Studios");
        inputGame.setQuantity(1);
        inputGame.setId(2);

        // Convert Java Object to JSON
        String inputJson = objectMapper.writeValueAsString(inputGame);

        mockMvc.perform(
                        put("/games/5")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}