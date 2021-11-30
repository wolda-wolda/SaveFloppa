package com.floppa;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        System.out.println("[RUS] Флоппа Гаэм лол :D");
        Room room = new Room();
        addStartingArea(room);
    }

    public static void addStartingArea(Room room){
        room.addRoom("east", new Room());
        room.addRoom("west", new Room());
        room.addRoom("north", new Room());
    }
}
