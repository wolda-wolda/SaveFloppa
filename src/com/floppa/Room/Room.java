package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Position.Pos;
import com.floppa.WorldObject.WorldObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<WorldObject> objects = new ArrayList<>();
    private Info info;
    private HashMap<Pos, Room> rooms = new HashMap<>();
    private Pos max = new Pos(5, 5);

    public Room(Info info) {
        this.info = info;
    }

    public void addRoom(Pos key, Room room) {
        this.rooms.put(key, room);
    }

    public HashMap<Pos, Room> getRooms() {
        return rooms;
    }

    public int getMaxX() {
        return max.getX();
    }

    public int getMaxY() {
        return max.getX();
    }

    public boolean hasDoorAt(Pos pos) {
        for (Pos x : rooms.keySet()) {
            if (pos.getX() == x.getX() && pos.getY() == pos.getY()) {
                return true;
            }
        }
        return false;
    }

    public void fillRoom(ArrayList<WorldObject> objects) {
        this.objects = objects;
    }

}
