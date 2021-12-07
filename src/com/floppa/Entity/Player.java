package com.floppa.Entity;

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
        this.pos = new Pos(0, 0);
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
        if ((pos.getX() < currentRoom.getMaxX() && pos.getY() < currentRoom.getMaxY()) && pos.getX() >= 0 && pos.getY() >= 0) {
            this.pos = pos;
            if (currentRoom.hasDoorAt(pos)) {
                currentRoom = currentRoom.getRooms().get(pos);
                System.out.println("Entered room at " + pos);
                this.pos = new Pos(0, 0);
            }
        } else {
            System.out.println("Wand");
        }
    }

    public void move(String ch) {
        switch (ch) {
            case "w" -> this.applyPos(this.pos.setPos(this.pos.getX(), this.pos.getY() + 1));
            case "s" -> this.applyPos(this.pos.setPos(this.pos.getX(), this.pos.getY() - 1));
            case "a" -> this.applyPos(this.pos.setPos(this.pos.getX() - 1, this.pos.getY()));
            case "d" -> this.applyPos(this.pos.setPos(this.pos.getX() + 1, this.pos.getY()));
            case "Exit" -> System.out.println("Du haßt das Spiel beendet");
            default -> System.out.println("Falsche Benutzereingabe verwende nur: W, S, A, D");
        }
    }
}
