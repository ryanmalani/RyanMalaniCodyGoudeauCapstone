package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    // Create

    @RequestMapping(value = "/games", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game) {
        return null;
    }

    // Read

    @RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        return null;
    }

    @RequestMapping(value = "/games/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {
        return null;
    }

    @RequestMapping(value = "/games/{esrb_rating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable String esrb_rating) {
        return null;
    }

    @RequestMapping(value = "/games/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {
        return null;
    }

    // Update

    @RequestMapping(value = "/games", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game) {
        return null;
    }

    // Delete

    @RequestMapping(value = "/games/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        return null;
    }
}
