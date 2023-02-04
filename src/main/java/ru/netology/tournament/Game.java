package ru.netology.tournament;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> playersList = new ArrayList<>();

    public void register(Player player) {
        playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) {
        for (Player player : playersList) {
            if (player.getName() == name) {
                return player;
            }
        }
        throw new NotRegisteredException("Element with name: " + name + " not found");
    }
}
