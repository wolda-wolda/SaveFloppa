package com.floppa.Entity;

import com.floppa.Info;
import com.floppa.Items.Food;
import com.floppa.Items.Inventory;
import com.floppa.Items.Item;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;
import com.floppa.WorldObject.WorldObject;

import java.util.ArrayList;

import static com.floppa.Menu.Menu.Menu;

public class Player extends Entity {
    private Inventory inventory = new Inventory(10);
    private Pos pos;
    private Info info;
    private Room currentRoom;
    private Floppa floppa;

    public Player(Info info, Room room, Floppa floppa) {
        super(info);
        this.pos = new Pos(3, 3);
        this.currentRoom = room;
        this.floppa = floppa;
        this.inventory.addItem(new Food(new Info("Apple", "ssf"), 10, 10));
    }

    public void grabWorldObject(Item item) {
        inventory.addItem(item);
    }

    public Item depositWorldObject(String string) {
        int i = inventory.findItem(string);
        if (i != -1) {
            return inventory.removeItem(i);
        }
        return null;
    }

    public Food depositFood(String string) {
        int i = inventory.findItem(string);
        if (i != -1) {
            return (Food) inventory.removeItem(i);
        }
        return null;
    }

    public Pos getPos() {
        return pos;
    }

    public String getPosString() {
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

    public Floppa getFloppa() {
        return floppa;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean comparePos(Pos x, Pos y) {
        if(x.getX() == y.getX() && x.getY() == y.getY()) {
            return true;
        }
        return false;
    }
}