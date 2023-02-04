package ru.netology.tournamentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.tournament.Game;
import ru.netology.tournament.NotRegisteredException;
import ru.netology.tournament.Player;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(5, "Jax", 90);
    Player player2 = new Player(7, "Scorpion", 80);
    Player player3 = new Player(8, "Sub-zero", 80);
    Player player4 = new Player(9, "JonyK", 70);
    Player player5 = new Player(10, "Shao-kahn", 100);

    Game game = new Game();

    @Test

    public void roundOneWinSecondPlayer() {

        game.register(player1);
        game.register(player4);

        int actual = game.round("JonyK", "Jax");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void roundTwoWinFirstPlayer() {

        game.register(player2);
        game.register(player5);

        int actual = game.round("Shao-kahn", "Scorpion");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void roundThreeDraw() {

        game.register(player2);
        game.register(player3);

        int actual = game.round("Scorpion", "Sub-zero");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void roundFourPlayerNotFound() {

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Scorpion", "Kitana"));

    }

    @Test

    public void roundFivePlayerVsNull() {

        game.register(player2);
        game.register(player3);


        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Scorpion", null));
    }
}
