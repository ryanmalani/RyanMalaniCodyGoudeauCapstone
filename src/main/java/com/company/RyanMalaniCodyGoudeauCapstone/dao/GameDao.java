package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getGames();

    void updateGame(Game game);

    void deleteGame(int id);

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByESRB(String esrbRating);

    List<Game> getGamesByTitle(String title);
}
