package com.floppa;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<WorldObject> objects;
    private ArrayList<Room> exit;
    private Info info;
    private HashMap<String, Room> rooms;

    void addRoom(String key, Room room) {
        rooms.put(key, room);
    }

    HashMap getRooms() {
        return rooms;
    }
}
