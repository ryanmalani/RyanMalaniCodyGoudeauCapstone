package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameInventoryDaoTest {

    @Autowired
    protected GameInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        List<Game> mList = dao.getAllGames();

        for(Game game: mList) {
            dao.deleteGame(game.getId());
        }
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
    public void addGetDeleteGame() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        game = dao.addGame(game);
        Game game1 = dao.getGame(game.getId());

        assertEquals(game, game1);

        dao.deleteGame(game.getId());
        game1 = dao.getGame(game.getId());

        assertNull(game1);

    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        game = dao.addGame(game);

        game.setTitle("FIFA");

        dao.updateGame(game);

        Game game1 = dao.getGame(game.getId());

        assertEquals(game, game1);
    }

    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("Fortnite");
        game.setEsrb_rating("Rated T");
        game.setDescription("A game where you make people until the end where there is only 1 left");
        game.setPrice(new BigDecimal("00.00"));
        game.setStudio("Epic Games");
        game.setQuantity(700);

        dao.addGame(game);
        List<Game> gameList = dao.getAllGames();

        assertEquals(2, gameList.size());
    }

    @Test
    public void getGamesByStudio() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Square");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Square");
        game.setQuantity(300);

        dao.addGame(game);
        List<Game> mList = dao.getGamesByStudio("Square");

        assertEquals(2, mList.size());

        mList = dao.getGamesByStudio("Bethesda");

        assertEquals(1, mList.size());

        mList = dao.getGamesByStudio("Epic Games");

        assertEquals(0, mList.size());
    }

    @Test
    public void getGamesByESRB_Rating() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("PayDay");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you essentially rob banks");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("Red Dead Redemption");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you play an outlaw in the West");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);
        List<Game> mList = dao.getGamesByESRB_Rating("Rated M");

        assertEquals(2, mList.size());

        mList = dao.getGamesByESRB_Rating("Rated E");

        assertEquals(1, mList.size());

        mList = dao.getGamesByESRB_Rating("Rated T");

        assertEquals(0, mList.size());
    }

    @Test
    public void getGamesByTitle() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("Red Dead Redemption");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you play an outlaw in the West");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        dao.addGame(game);

        game = new Game();
        game.setTitle("Red Dead Redemption");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you play an outlaw in the West");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(500);

        dao.addGame(game);
        List<Game> mList = dao.getGamesByTitle("Red Dead Redemption");

        assertEquals(2, mList.size());

        mList = dao.getGamesByTitle("Portal");

        assertEquals(1, mList.size());

        mList = dao.getGamesByTitle("FIFA");

        assertEquals(0, mList.size());
    }
}