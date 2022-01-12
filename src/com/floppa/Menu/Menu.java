package com.floppa.Menu;

import Config.SaveGame.SaveGame;
import com.floppa.Entity.Player;
import com.floppa.Items.Item;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;
import com.floppa.exception.userInputExcepetion;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static com.floppa.Menu.Help.helpPage;
import static com.floppa.Menu.MainMenu.mainMenu;

/**
 * Class for implementing the in-game Menu
 */
public abstract class Menu {
    private boolean asked;

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
                        var i = player1.getCurrentRoom().getObjects().get(pos).open();
                        while (i != null) {
                            player1.getInventory().addItem(i);
                            i = player1.getCurrentRoom().getObjects().get(pos).open();
                            if (i != null && Objects.equals(i.getInfo(), "key")) {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("Inside the cest along some food was a book.\n" +
                                        "After opening you have to know which of the following assumptions is correct?\n" +
                                        "a.\tCaracals prey on rabbits.\n" +
                                        "b.\tCaracals eat only vegetable.\n" +
                                        "c.\tCaracals prey on their own kids.\n" +
                                        "Enter letter of correct answer: ");
                                String answer = scanner.nextLine();
                                while (!Objects.equals(answer, "a")) {
                                    System.out.println("Wrong answer try again!");
                                    answer = scanner.nextLine();
                                }
                                System.out.println("Right answer! You got a key for the second room. Which is at position 5, 3\n" +
                                        "You are wondering what behind that door is you carefully approach it.\n");

                            } else if (i != null && Objects.equals(i.getInfo(), "flower")) {
                                System.out.println("The next door opened magically");
                                for (HashMap.Entry<String, Room> r : player1.getStartRoom().getRooms().entrySet()) {
                                    if (Objects.equals(r.getValue().getInfo().getName(), "ThirdRoom") && !r.getValue().isUnlockable()) {
                                        r.getValue().setUnlockable();
                                    }
                                }
                            } else if (i != null && Objects.equals(i.getInfo(), "golden key")) {
                                for (HashMap.Entry<String, Room> r : player1.getStartRoom().getRooms().entrySet()) {
                                    if (Objects.equals(r.getValue().getInfo().getName(), "FourthRoom") && !r.getValue().isUnlockable()) {
                                        r.getValue().setUnlockable();
                                    }
                                }
                            }
                        }
                        player1.getInventory().print();
                    }
                }
            }
            case "continue" -> {
                break;
            }
            case "help" -> helpPage();
            case "menu" -> Menu(mainMenu(), player1);
            case "inventory" -> player1.getInventory().print();
            case "info" -> {
                switch (newStr[1]) {
                    case "player" -> {
                        player1.getInfo().printInfo();
                        player1.printInfo();
                        player1.getInventory().print();
                    }
                    case "floppa" -> {
                        player1.getFloppa().getInfo().printInfo();
                        player1.getFloppa().printInfo();
                    }
                    case "room" -> {
                        player1.getCurrentRoom().getInfo().printInfo();
                        player1.getCurrentRoom().printInfo();
                    }
                }
            }
            default -> {
                try {
                    throw new userInputExcepetion();
                } catch (userInputExcepetion e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
