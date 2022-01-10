package com.floppa.Entity;

import com.floppa.Info;
import com.floppa.Items.Food;
import com.floppa.Items.Inventory;
import com.floppa.Items.Item;
import com.floppa.Menu.SoundPlayer;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static com.floppa.Menu.Menu.Menu;
import static java.lang.Thread.sleep;

/***
 * Class for creating a playable Character
 */
public class Player extends Entity {
    private Inventory inventory = new Inventory(10);
    private Pos pos;
    private Info info;
    private Room currentRoom;
    private Floppa floppa;
    private Enemy currentEnemy;

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
        this.inventory.addItem(new Food(new Info("apple", "ssf"), 10, 10));
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
        return this.pos.getX() + "," + this.pos.getY();
    }

    /***
     * Check if the new Position is a valid one and interact with Doors or WorldObjects
     * at the Position
     * @param pos
     */
    public void applyPos(Pos pos) {
        SoundPlayer soundPlayer = new SoundPlayer();
        Scanner scanner = new Scanner(System.in);
        if ((pos.getX() <= currentRoom.getMaxX() && pos.getY() <= currentRoom.getMaxY()) && pos.getX() >= 0 && pos.getY() >= 0) {
            this.pos = pos;
            if (currentRoom.hasDoorAt(pos)) {
                String strPos = currentRoom.keyToString(pos);
                if (currentRoom.getRooms().get(strPos).getEnemies().size() > 0) {
                    System.out.println("Attention! Enemies are in this Room they will attack you! Are you sure you want to enter this Room? Yes or No");
                    if (Objects.equals(scanner.nextLine().toLowerCase(), "yes")) {
                        if (switchRoom(strPos)) {
                            System.out.println("Entered room at " + pos.getX() + ", " + pos.getY());
                            this.pos = new Pos(3, 3);

                            if (this.floppa.isDead()) {
                                System.out.println("Your Floppa died: GAME OVER");
                                try {
                                    Clip clip = AudioSystem.getClip();
                                    soundPlayer.playSound(clip, "/src/Config/gameOver.wav", false);
                                    sleep(2000);
                                } catch (LineUnavailableException | InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.exit(0);
                            } else {
                                this.floppa.isStarving();
                            }

                            System.out.println("The Enemies noticed you and starting to attack you");
                            currentEnemy.attackPlayer(this, currentRoom);
                        }
                    } else {
                        System.out.println("You didn't entered the room, your character Position got reset to the default Position");
                        this.pos = new Pos(3, 3);
                    }
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
    public boolean switchRoom(String strPos) {
        Room tmp = currentRoom;
        if (currentRoom.getRooms().get(strPos).isLocked()) {
            System.out.println("You have to unlock the door first");
            if (this.getInventory().findItem("key") != -1) {
                Item key = inventory.removeItem(this.getInventory().findItem("key"));
                this.currentRoom.getRooms().get(strPos).unlock(key);
                this.currentRoom = currentRoom.getRooms().get(strPos);
                switch (strPos) {
                    case "5,3" -> currentRoom.addRoom(currentRoom.stringToKey("0,3"), tmp);
                    case "3,5" -> currentRoom.addRoom(currentRoom.stringToKey("3,0"), tmp);
                    case "0,3" -> currentRoom.addRoom(currentRoom.stringToKey("5,3"), tmp);
                    case "3,0" -> currentRoom.addRoom(currentRoom.stringToKey("3,5"), tmp);
                }
                currentEnemy = currentRoom.getEnemies().get(currentRoom.getEnemies().size() - 1);
                return true;
            } else {
                System.out.println("You have to find the key for this room first! Hint: Search for chests in other rooms");
                applyPos(new Pos(3, 3));
                System.out.println("Position reset");
                return false;
            }
        }
        return false;
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
        if (x.getX() == y.getX() && x.getY() == y.getY()) {
            return true;
        }
        return false;
    }

    public void setCurrentRoom(String currentRoom) {
        for (Map.Entry<String, Room> room : this.currentRoom.getRooms().entrySet()) {
            if (Objects.equals(room.getValue().getInfo().getName(), currentRoom)) {
                this.currentRoom = room.getValue();
            }
        }
    }

    public void fight() {

    }
}