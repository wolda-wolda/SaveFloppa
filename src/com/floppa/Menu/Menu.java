package com.floppa.Menu;

import Config.SaveGame.SaveGame;
import com.floppa.Entity.Player;
import com.floppa.Position.Pos;

import static com.floppa.Menu.Help.helpPage;
import static com.floppa.Menu.MainMenu.mainMenu;

/**
 * Class for implementing the in-game Menu
 */
public abstract class Menu {
    /***
     * Handles Player Input
     */
    public static void Menu(String ch, Player player1) {
        String string = ch.toLowerCase();
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
            case "save" -> SaveGame.saveGame(player1);
            case "load" -> SaveGame.loadGame(player1);
            case "feed" -> {
                switch (newStr[1]) {
                    case "floppa" -> player1.getFloppa().levelUp(player1, newStr[2]);
                    case "player" -> player1.levelUp(player1, newStr[2]);
                }
            }
            case "heal" -> {
                switch (newStr[1]) {
                    case "floppa" -> player1.getFloppa().heal(player1, newStr[2]);
                    case "player" -> player1.heal(player1, newStr[2]);
                }
            }
            case "open" -> {
                for (Pos pos : player1.getCurrentRoom().getObjects().keySet()) {
                    if (player1.comparePos(pos, player1.getPos())) {
                        player1.getInventory().addItem(player1.getCurrentRoom().getObjects().get(pos).open());
                        player1.getInventory().print();
                    }
                }
            }
            case "continue" -> {
                break;
            }
            case "help" -> helpPage();
            case "menu" -> Menu(mainMenu(), player1);
            default -> System.out.println("Command not recognised! Need help? Use the help command");
        }
    }
}
