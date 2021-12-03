package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Position.Position;
import com.floppa.WorldObject.WorldObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<WorldObject> objects = new ArrayList<>();
    private Info info;
    private HashMap<Position, Room> rooms = new HashMap<>();
    private Position max = new Position(5, 5);

    public Room(Info info) {
        this.info = info;
    }

    public void addRoom(Position key, Room room) {
        this.rooms.put(key, room);
    }

    public HashMap<Position, Room> getRooms() {
        return rooms;
    }

    public int getMaxX() {
        return max.getX();
    }

    public int getMaxY() {
        return max.getX();
    }

    public boolean hasDoorAt(Position pos) {
        for (Position x : rooms.keySet()) {
            if (pos.getX() == x.getX() && pos.getY() == pos.getY()) {
                return true;
            }
        }
        return false;
    }
}
