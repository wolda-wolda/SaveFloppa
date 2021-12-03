package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Position.Position;
import com.floppa.WorldObject.WorldObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<WorldObject> objects = new ArrayList<>();
    private ArrayList<Room> exit;
    private Info info;
    private HashMap<String, Room> rooms = new HashMap<>();
    private Position max = new Position(5, 5);

    public Room(Info info) {
        this.info = info;
    }

    public void addRoom(String key, Room room) {
        this.rooms.put(key, room);
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
}
