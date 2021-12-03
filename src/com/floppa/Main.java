package com.floppa;

import com.floppa.Entity.Player;
import com.floppa.Items.Food;
import com.floppa.Room.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        System.out.println("[RUS] Флоппа Гаэм лол :D");
        Scanner scanner = new Scanner(System.in);
        Room room = new Room(new Info("StartRoom", "IDK"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room);
        player1.levelUp(new Food(new Info("Apfel", "Macht die groß und Stark"), 10));

        addStartingArea(room);
        for (int i = 0; i < 5; i++) {
            System.out.println("Input: ");
            char ch = scanner.next().charAt(0);
            player1.move(ch);
            System.out.println("com.floppa.Position.Position des aktuellen Spielers: " + player1.getPos());
        }
    }

    public static void addStartingArea(Room room) {
        room.addRoom("east", new Room(new Info("EasternRoom", "IDK")));
        room.addRoom("west", new Room(new Info("WesternRoom", "IDK")));
        room.addRoom("north", new Room(new Info("NorthernRoom", "IDK")));
    }
}