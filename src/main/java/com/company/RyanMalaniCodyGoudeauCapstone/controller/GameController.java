package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private ServiceLayer serviceLayer;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {

        serviceLayer.addGame(game);

        return game;
    }

    // Read

    @GetMapping(value = "/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {

        return serviceLayer.getGame(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {

        List<Game> gameList = serviceLayer.getAllGames();

        return gameList;
    }

    @GetMapping(value = "/studio/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {

        List<Game> gameList = serviceLayer.getGamesByStudio(studio);

        return gameList;
    }

    @GetMapping(value = "/esrb_rating/{esrb_rating}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable String esrb_rating) {

        List<Game> gameList = serviceLayer.getGamesByESRB_Rating(esrb_rating);

        return gameList;
    }

    @GetMapping(value = "/title/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {

        List<Game> gameList = serviceLayer.getGamesByTitle(title);

        return gameList;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable int id, @RequestBody @Valid Game game) {

        if(game.getId() != id) {
            throw new IllegalArgumentException("Game ID must match parameter given.");
        }

        serviceLayer.updateGame(game);
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {

        serviceLayer.deleteGame(id);
    }
}
