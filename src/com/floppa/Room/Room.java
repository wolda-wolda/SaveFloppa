package com.floppa.Room;

import com.floppa.Entity.Enemy;
import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Items.Item;
import com.floppa.Position.Pos;
import com.floppa.WorldObject.Chest;
import com.floppa.WorldObject.WorldObject;

import java.util.*;

/***
 * Class for adding new Rooms to the World
 */

public class Room implements Interaction {
    private LinkedHashMap<Pos, WorldObject> objects = new LinkedHashMap<>();
    private Info info;
    private LinkedHashMap<String, Room> rooms = new LinkedHashMap<>();
    private ArrayList<Pos> avoid = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Pos max = new Pos(5, 5);
    private boolean locked;
    private boolean unlockable;
    private String instruction;

    /***
     * Takes the parameter Info which contains the name and description of the room
     * Sets new Positions in the avoid ArrayList, which contains Positions where
     * Worldobjects should not spawn
     * @param info
     */
    public Room(Info info, boolean locked, String instruction, boolean unlockable) {
        this.info = info;
        this.locked = locked;
        this.instruction = instruction;
        this.unlockable = unlockable;
        avoid.add(new Pos(0, 3));
        avoid.add(new Pos(3, 0));
        avoid.add(new Pos(3, 5));
        avoid.add(new Pos(5, 3));
        avoid.add(new Pos(3, 3));
    }

    /***
     * Links the current Room to another Room
     * The Position is determined by the parameter key
     * and the new Room has to be given
     * @param key
     * @param room
     */
    public void addRoom(Pos key, Room room) {
        String strKey = keyToString(key);
        this.rooms.put(strKey, room);
    }

    /***
     * Returns the rooms which are connected to the current Room
     * @return
     */
    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    /***
     * Returns the length of the Room on the X-Axis
     * @return
     */
    public int getMaxX() {
        return max.getX();
    }

    /***
     * Return the length of the Room on the Y-Axis
     * @return
     */
    public int getMaxY() {
        return max.getX();
    }

    /***
     * Checks if there is a door, so a link to another room, at a given Position
     * Returns a true if there is one, false if there is none
     * @param pos
     * @return
     */
    public boolean hasDoorAt(Pos pos) {
        System.out.println(rooms.keySet());
        String key = keyToString(pos);
        for (String roomKey : rooms.keySet()) {
            if (key.equals(roomKey)) {
                return true;
            }
        }
        return false;
    }

    /***
     * Checks if there is a WorldObject at a given Position
     * If there is, prints it to the console, along with its position
     * @param pos
     */
    public void hasWorldObjectAt(Pos pos) {
        int i = 0;
        String[] stringPos = new String[objects.size()];
        Pos[] position = objects.keySet().toArray(new Pos[0]);
        String key = keyToString(pos);

        for (Pos p : position) {
            if (key.equals(stringPos[i] = this.keyToString(p))) {
                System.out.println("object: " + this.whichObject(p) + "is located on your current position: " + this.keyToString(p));
            }
            i++;
        }
    }

    /***
     * Convert a Key in String Format to a Key in Position Format
     * @param pos
     * @return
     */
    public Pos stringToKey(String pos) {
        String[] tmp = pos.split(",");
        return new Pos(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }

    /***
     * Convert a Key in Position Format to a Key in String Format
     * @param pos
     * @return
     */
    public String keyToString(Pos pos) {
        String x = String.valueOf(pos.getX());
        String y = String.valueOf(pos.getY());
        return x + "," + y;
    }

    /***
     * Fills the Room with randomly selected and given WorldObjects.
     * The Contents in the WorldObjects are also given and randomly selected.
     * @param wObjects
     * @param items
     */
    public void fill(ArrayList<WorldObject> wObjects, ArrayList<Item> items) {
        for (WorldObject w : wObjects) {
            Pos tmpPos = getRandomPosRoom(avoid);
            w.addItem(items);
            objects.put(tmpPos, w);
            avoid.add(tmpPos);
        }
    }

    /***
     * Checks if there is a WorldObject in the current Room
     * If there is, prints it to the console, along with its position
     */
    public void printWorldObjects() {
        int i = 0;
        Pos[] pos = objects.keySet().toArray(new Pos[0]);
        for (WorldObject o : objects.values()) {
            if (o.getClass() == Chest.class) {
                System.out.println("There is a chest in this room located at position: " + this.keyToString(pos[i]));
            } else if (o.getClass() == WorldObject.class) {
                System.out.println("There is a world object in this room located at position: " + this.keyToString(pos[i]));
            }
            i++;
        }
    }

    /***
     * Returns the Type of the WorldObject in String Format
     * @param p
     * @return
     */
    public String whichObject(Pos p) {
        if (objects.get(p).getClass() == Chest.class) {
            return "Chest ";
        } else {
            return "Other object ";
        }
    }

    /***
     * Returns a random Position within the Room Bounds
     * @param avoid
     * @return
     */
    public Pos getRandomPosRoom(ArrayList<Pos> avoid) {
        Random rng = new Random();
        Pos pos;
        do {
            int x = rng.nextInt(5);
            int y = rng.nextInt(5);
            pos = new Pos(x, y);
        } while (comparePos(pos, avoid));
        return pos;
    }

    /***
     * Returns if a randomly generated Position is allowed or not
     * Unallowed Positions are given through an ArrayList
     * @param pos
     * @param avoid
     * @return true or false
     */
    public boolean comparePos(Pos pos, ArrayList<Pos> avoid) {
        for (Pos x : avoid) {
            if (pos.getX() == x.getX() && pos.getY() == x.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Hashmap with the WorldObejects from the current room
     */
    public LinkedHashMap<Pos, WorldObject> getObjects() {
        return objects;
    }

    /**
     * @return Info class
     */
    public Info getInfo() {
        return info;
    }

    /**
     * Return the enemies
     *
     * @return
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * Add a given Amount of Enemies with a given Level to the Room
     * @param count
     * @param level
     */
    public void addEnemy(int count, int level) {
        Info defaultInfo = new Info("NPC Enemy", "Attacks Player and Floppa");
        for (int i = 0; i < count; i++) {
            enemies.add(new Enemy(defaultInfo, level));
        }
    }

    /**
     * Remove an Enemy from the World and display a Kill Message
     */
    public void removeEnemy() {
        System.out.println("You killed an Enemy still " + (enemies.size() - 1) + " Enemies left");
        enemies.remove(0);
    }

    /**
     * Return the Locked Status of the Room
     * @return
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Opens the Room
     * @return
     */
    @Override
    public Item open() {
        return null;
    }

    /**
     * Unlock the Room using a Key
     * @param key
     */
    @Override
    public void unlock(Item key) {
        if (this.locked) {
            locked = false;
            System.out.println("You unlocked the door");
            open();
        }
    }

    public void printInstruction() {
        System.out.println(instruction);
    }

    public boolean isUnlockable() {
        return unlockable;
    }

    public void setUnlockable() {
        this.unlockable = !unlockable;
    }
}