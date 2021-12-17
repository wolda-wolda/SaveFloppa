package com.floppa.Menu;

import Config.SaveGame.SaveGame;
import com.floppa.Entity.Player;
import com.floppa.Position.Pos;

public class Menu {
    public static void Menu(String ch, Player player1) {
        String string = ch;
        String[] newStr = string.split("\\s+");
        switch (newStr[0]) {
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
                switch (newStr[1]) {
                    case "Floppa" -> player1.getFloppa().levelUp(player1, newStr[2]);
                    case "Player" -> player1.levelUp(player1, newStr[2]);
                }
            }
            case "heal" -> {
                switch (newStr[1]) {
                    case "Floppa" -> player1.getFloppa().heal(player1, newStr[2]);
                    case "Player" -> player1.heal(player1, newStr[2]);
                }
            }
            default -> System.out.println("Falsche Benutzereingabe verwende nur: W, S, A, D");
            case "Open" -> {
                for (Pos pos : player1.getCurrentRoom().getObjects().keySet()) {
                    if(player1.comparePos(pos, player1.getPos())) {
                        player1.getInventory().addItem(player1.getCurrentRoom().getObjects().get(pos).open());
                        player1.getInventory().print();
                    }
                }
            }
        }
    }
}
