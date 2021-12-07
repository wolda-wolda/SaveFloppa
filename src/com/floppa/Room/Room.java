package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Position.Pos;
import com.floppa.WorldObject.WorldObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<WorldObject> objects = new ArrayList<>();
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

    public Pos stringToKey(String pos) {
        String []tmp = pos.split(",");
        return new Pos(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }

    public String keyToString(Pos pos) {
        String x = String.valueOf(pos.getX());
        String y = String.valueOf(pos.getY());
        return x + "," + y;
    }
}
