package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.GameInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameInventoryDao gameDao;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {

        gameDao.addGame(game);

        return game;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {

        return gameDao.getGame(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {

        List<Game> gameList = gameDao.getAllGames();

        return gameList;
    }

    @GetMapping(value = "/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {

        List<Game> gameList = gameDao.getGamesByStudio(studio);

        return gameList;
    }

    @GetMapping(value = "/{esrb_rating}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable String esrb_rating) {

        List<Game> gameList = gameDao.getGamesByESRB_Rating(esrb_rating);

        return gameList;
    }

    @GetMapping(value = "/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {

        List<Game> gameList = gameDao.getGamesByTitle(title);

        return gameList;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable int id, @RequestBody @Valid Game game) {

//        if(game.getId() == null) {
//            game.setId(id);
//        }

        if(game.getId() != id) {
            throw new IllegalArgumentException("Game ID must match parameter given.");
        }

        gameDao.updateGame(game);
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {

        gameDao.deleteGame(id);
    }
}
