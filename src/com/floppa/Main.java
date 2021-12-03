package com.floppa;

import com.floppa.Entity.Player;
import com.floppa.Items.Food;
import com.floppa.Position.Position;
import com.floppa.Room.Room;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        Scanner scanner = new Scanner(System.in);
        String ch = "";
        Room room = new Room(new Info("StartRoom", "IDK"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room);
        player1.levelUp(new Food(new Info("Apfel", "Macht die groß und Stark"), 10));

        addStartingArea(room);
        while (!Objects.equals(ch, "Exit")) {
            System.out.println("INPUT: ");
            ch = scanner.next();
            player1.move(ch);
            if (!Objects.equals(ch, "Exit")) {
                System.out.println("Position des aktuellen Spielers: " + player1.getPos());
            }
        }
    }

    public static void addStartingArea(Room room) {
        room.addRoom(new Position(5, 3), new Room(new Info("EasternRoom", "IDK")));
        room.addRoom(new Position(0, 1), new Room(new Info("WesternRoom", "IDK")));
        room.addRoom(new Position(3, 5), new Room(new Info("NorthernRoom", "IDK")));
    }
}