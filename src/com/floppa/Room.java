package com.floppa;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<WorldObject> objects;
    private ArrayList<Room> exit;
    private Info info;
    private HashMap<String, Room> rooms;

    public Room(Info info) {
        this.info = info;
    }

    void addRoom(String key, Room room) {
        this.rooms.put(key, room);
    }

    HashMap<String, Room> getRooms() {
        return rooms;
    }
}
