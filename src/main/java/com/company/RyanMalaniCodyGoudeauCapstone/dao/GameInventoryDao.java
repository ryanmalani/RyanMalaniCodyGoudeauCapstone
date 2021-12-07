package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;

import java.util.List;

public interface GameInventoryDao {

    Game getGame(int id);
    List<Game> getAllGames();
    Game addGame(Game game);
    void updateGame(Game game);
    void deleteGame(int id);
    List<Game> getGamesByStudio(String studio);
    List<Game> getGamesByESRB_Rating(String esrb_rating);
    List<Game> getGamesByTitle(String title);
}
