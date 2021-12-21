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

/***
 * Class for creating a playable Character
 */
public class Player extends Entity {
    private Inventory inventory = new Inventory(10);
    private Pos pos;
    private Info info;
    private Room currentRoom;
    private Floppa floppa;

    /***
     * Sets the Info, so the Name and Description of the Player
     * Sets its current Position to default
     * Sets the Starting Room as the Current Room and sets a Floppa
     * @param info
     * @param room
     * @param floppa
     */
    public Player(Info info, Room room, Floppa floppa) {
        super(info);
        this.pos = new Pos(3, 3);
        this.currentRoom = room;
        this.floppa = floppa;
        this.inventory.addItem(new Food(new Info("Apple", "ssf"), 10, 10));
    }

    /***
     * Method for picking up Items and adding them to the Inventory
     * @param item
     */
    public void grabItem(Item item) {
        inventory.addItem(item);
    }

    /***
     * Method for dropping the first Occurence of a given Item from the Inventory
     * The Item is searched by Name
     * @param string
     * @return
     */
    public Item depositWorldObject(String string) {
        int i = inventory.findItem(string);
        if (i != -1) {
            return inventory.removeItem(i);
        }
        return null;
    }

    /***
     * Method for dropping the first Occurence of a given Food from the Inventory
     * The Food is searched by Name
     * @param string
     * @return
     */
    public Food depositFood(String string) {
        int i = inventory.findItem(string);
        if (i != -1) {
            return (Food) inventory.removeItem(i);
        }
        return null;
    }

    /***
     * Return the current Position of the Player
     * @return
     */
    public Pos getPos() {
        return pos;
    }

    /***
     * Return the current Position of the Player as a String
     * @return
     */
    public String getPosString() {
        return this.pos.getX() + "|" + this.pos.getY();
    }

    /***
     * Check if the new Position is a valid one and interact with Doors or WorldObjects
     * at the Position
     * @param pos
     */
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

    /***
     * Handles switching to another Room
     * @param strPos
     */
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

    /***
     * Converts a Key in String Format to a Key in Position Format and sets it as the Current
     * @param pos
     */
    public void stringToKey(String pos) {
        String[] tmp = pos.split(",");
        this.pos = new Pos(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }

    /***
     * Return the Floppa
     * @return
     */
    public Floppa getFloppa() {
        return floppa;
    }

    /***
     * Return the current Room
     * @return
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /***
     * Return the Player Inventory
     * @return
     */
    public Inventory getInventory() {
        return inventory;
    }

    /***
     * Compare if two Positions are equal
     * X and Y Values are compared separately
     * Returns True if they are equal, false if not
     * @param x
     * @param y
     * @return
     */
    public boolean comparePos(Pos x, Pos y) {
        if(x.getX() == y.getX() && x.getY() == y.getY()) {
            return true;
        }
        return false;
    }
}