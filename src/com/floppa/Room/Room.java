package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Position.Pos;
import com.floppa.WorldObject.Chest;
import com.floppa.WorldObject.WorldObject;

import java.util.*;

public class Room {
    private LinkedHashMap<Pos, WorldObject> objects = new LinkedHashMap<>();
    private Info info;
    private HashMap<String, Room> rooms = new HashMap<>();
    private Pos max = new Pos(5, 5);

    public Room(Info info) {
        this.info = info;
    }

    public void addRoom(Pos key, Room room) {
        String strKey = keyToString(key);
        this.rooms.put(strKey, room);
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public int getMaxX() {
        return max.getX();
    }

    public int getMaxY() {
        return max.getX();
    }

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

    public void hasWorldObjectAt(Pos pos) {
        int i = 0;
        String[] stringPos = new String[objects.size()];
        Pos[] position = objects.keySet().toArray(new Pos[0]);
        String key = keyToString(pos);

        for (Pos p : position) {
            if (key.equals(stringPos[i] = this.keyToString(p))) {
                System.out.println("Objekt: " + this.whichObject(p) + "befindet sich an der aktuellen Stelle: " + this.keyToString(p));
            }
            i++;
        }
    }

    public Pos stringToKey(String pos) {
        String[] tmp = pos.split(",");
        return new Pos(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }

    public String keyToString(Pos pos) {
        String x = String.valueOf(pos.getX());
        String y = String.valueOf(pos.getY());
        return x + "," + y;
    }

    public void fillRoom(LinkedHashMap<Pos, WorldObject> objects) {
        this.objects = objects;
    }

    public void printWorldObjects() {
        int i = 0;
        Pos[] pos = objects.keySet().toArray(new Pos[0]);
        for (WorldObject o : objects.values()) {
            if (o.getClass() == Chest.class) {
                System.out.println("Im Raum befindet sich eine Kiste an der Position: " + this.keyToString(pos[i]));
            } else if (o.getClass() == WorldObject.class) {
                System.out.println("Im Raum befindet sich ein WorldObjekt an der Position: " + this.keyToString(pos[i]));
            }
            i++;
        }
    }

    public String whichObject(Pos p) {
        if (objects.get(p).getClass() == Chest.class) {
            return "Kiste ";
        } else {
            return "Anderes Objekt ";
        }
    }
}