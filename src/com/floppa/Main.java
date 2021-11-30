package com.floppa;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        System.out.println("[RUS] Флоппа Гаэм лол :D");
        Room room = new Room(new Info("StartRoom", "IDK"));
        addStartingArea(room);
    }

    public static void addStartingArea(Room room) {
        room.addRoom("east", new Room(new Info("EasternRoom", "IDK")));
        room.addRoom("west", new Room(new Info("WesternRoom", "IDK")));
        room.addRoom("north", new Room(new Info("NorthernRoom", "IDK")));
    }
}
