package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        return null;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {
        return null;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        return null;
    }

    @GetMapping(value = "/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {
        return null;
    }

    @GetMapping(value = "/{esrb_rating}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable String esrb_rating) {
        return null;
    }

    @GetMapping(value = "/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {
        return null;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable int id, @RequestBody @Valid Game game) {
        return null;
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        return null;
    }
}
