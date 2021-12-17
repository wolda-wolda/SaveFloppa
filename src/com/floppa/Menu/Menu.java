package com.floppa.Menu;

import Config.SaveGame.SaveGame;
import com.floppa.Entity.Player;

public class Menu {
    public static void Menu(String ch, Player player1) {
        String string = ch;
        String[] parts = string.split(" ");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

        switch (part1) {
            case "w" -> player1.applyPos(player1.getPos().setPos(player1.getPos().getX(), player1.getPos().getY() + 1));
            case "s" -> player1.applyPos(player1.getPos().setPos(player1.getPos().getX(), player1.getPos().getY() - 1));
            case "a" -> player1.applyPos(player1.getPos().setPos(player1.getPos().getX() - 1, player1.getPos().getY()));
            case "d" -> player1.applyPos(player1.getPos().setPos(player1.getPos().getX() + 1, player1.getPos().getY()));
            case "Exit" -> {
                System.out.println("You closed the game");
                System.exit(0);
            }
            case "Save" -> SaveGame.saveGame(player1);
            case "Load" -> SaveGame.loadGame(player1);
            case "Feed" -> {
                switch (part2) {
                    case "Floppa":
                        player1.getFloppa().levelUp(player1, part3);
                    case "Player":
                        player1.levelUp(player1, part3);
                }
            }
            default -> System.out.println("Falsche Benutzereingabe verwende nur: W, S, A, D");
        }
    }
}
