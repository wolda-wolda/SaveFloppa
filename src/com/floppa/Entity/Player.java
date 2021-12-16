package com.floppa.Entity;

import Config.SaveGame.SaveGame;
import com.floppa.Info;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;
import com.floppa.WorldObject.WorldObject;

import java.util.ArrayList;

public class Player extends Entity {
    private ArrayList<WorldObject> inventory = new ArrayList<>();
    private Pos pos;
    private Info info;
    private Room currentRoom;
    private Floppa floppa;

    public Player(Info info, Room room, Floppa floppa) {
        super(info);
        this.pos = new Pos(3, 3);
        this.currentRoom = room;
        this.floppa = floppa;
    }

    void grabWorldObject() {
        //Add Item to Inventory
    }

    void depositWorldObject() {
        //Drop or put an Item somewhere
    }


    public String getPos() {
        return this.pos.getX() + "|" + this.pos.getY();
    }

    public void applyPos(Pos pos) {
        if ((pos.getX() <= currentRoom.getMaxX() && pos.getY() <= currentRoom.getMaxY()) && pos.getX() >= 0 && pos.getY() >= 0) {
            this.pos = pos;
            if (currentRoom.hasDoorAt(pos)) {
                String strPos = currentRoom.keyToString(pos);
                switchRoom(strPos);

                System.out.println("Entered room at " + pos.getX() + ", " + pos.getY());
                this.pos = new Pos(3, 3);
                if (this.floppa.isDead()) {
                    System.out.println("Your Floppa died: GAME OVER");
                    Menu("Exit", this);
                } else {
                    this.floppa.isStarvin();
                }
            }
            currentRoom.hasWorldObjectAt(pos);
        } else {
            System.out.println("Wand");
        }
    }

    public void Menu(String ch, Player player1) {
        switch (ch) {
            case "w" -> this.applyPos(this.pos.setPos(this.pos.getX(), this.pos.getY() + 1));
            case "s" -> this.applyPos(this.pos.setPos(this.pos.getX(), this.pos.getY() - 1));
            case "a" -> this.applyPos(this.pos.setPos(this.pos.getX() - 1, this.pos.getY()));
            case "d" -> this.applyPos(this.pos.setPos(this.pos.getX() + 1, this.pos.getY()));
            case "Exit" -> {
                System.out.println("Du haßt das Spiel beendet");
                System.exit(0);
            }
            case "Save" -> SaveGame.saveGame(player1);
            case "Load" -> SaveGame.loadGame(player1);
            default -> System.out.println("Falsche Benutzereingabe verwende nur: W, S, A, D");
        }
    }

    public void switchRoom(String strPos) {
        Room tmp = currentRoom;
        this.currentRoom = currentRoom.getRooms().get(strPos);
        switch (strPos) {
            case "5,3" -> currentRoom.addRoom(currentRoom.stringToKey("0,3"), tmp);
            case "3,5" -> currentRoom.addRoom(currentRoom.stringToKey("3,0"), tmp);
            case "0,3" -> currentRoom.addRoom(currentRoom.stringToKey("5,3"), tmp);
            case "3,0" -> currentRoom.addRoom(currentRoom.stringToKey("3,5"), tmp);
        }
    }

    public void stringToKey(String pos) {
        String[] tmp = pos.split(",");
        this.pos = new Pos(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }
}