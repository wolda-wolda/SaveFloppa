package com.floppa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        System.out.println("[RUS] Флоппа Гаэм лол :D");
        Scanner scanner = new Scanner(System.in);
        Room room = new Room(new Info("StartRoom", "IDK"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room);

        addStartingArea(room);
        for (int i = 0; i == i; i++) {
            char ch = scanner.next().charAt(0);
            player1.move(ch);
            System.out.println("Position des aktuellen Spielers: " + player1.getPos());
        }
    }

    public static void addStartingArea(Room room) {
        room.addRoom(new Position(5, 3), new Room(new Info("EasternRoom", "IDK")));
        room.addRoom(new Position(0, 1), new Room(new Info("WesternRoom", "IDK")));
        room.addRoom(new Position(3, 5), new Room(new Info("NorthernRoom", "IDK")));
    }
}