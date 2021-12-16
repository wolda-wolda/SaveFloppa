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

    public Player(Info info, Room room) {
        this.info = info;
        this.pos = new Pos(3, 3);
        this.currentRoom = room;
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
                this.currentRoom = currentRoom.getRooms().get(strPos);
                System.out.println("Entered room at " + pos.getX() + ", " + pos.getY());
                this.pos = new Pos(3, 3);
            }
            currentRoom.hasWorldObjectAt(pos);
        } else {
            System.out.println("Wand");
        }
    }

    public void move(String ch, Player player1) {
        switch (ch) {
            case "w" -> this.applyPos(this.pos.setPos(this.pos.getX(), this.pos.getY() + 1));
            case "s" -> this.applyPos(this.pos.setPos(this.pos.getX(), this.pos.getY() - 1));
            case "a" -> this.applyPos(this.pos.setPos(this.pos.getX() - 1, this.pos.getY()));
            case "d" -> this.applyPos(this.pos.setPos(this.pos.getX() + 1, this.pos.getY()));
            case "Exit" -> System.out.println("Du haßt das Spiel beendet");
            case "Save" -> SaveGame.saveGame(player1);
            case "Load" -> SaveGame.loadGame(player1);
            default -> System.out.println("Falsche Benutzereingabe verwende nur: W, S, A, D");
        }
    }

    public void stringToKey(String pos) {
        String[] tmp = pos.split(",");
        this.pos = new Pos(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }
}