package com.floppa;

import com.floppa.Entity.Player;
import com.floppa.Items.Food;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        System.out.println("[RUS] Флоппа Гаэм лол :D");
        Scanner scanner = new Scanner(System.in);
        Room room = new Room(new Info("StartRoom", "IDK"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room);
        player1.levelUp(new Food(new Info("Apfel", "Macht die groß und Stark"), 10,1));
        player1.heal(new Food(new Info("Birne", "Dein HP wird steigen"),1,101));
        player1.heal(new Food(new Info("Apfel", "Dein HP wird steigen"),1,2));


        addStartingArea(room);
        for (int i = 0; i == i; i++) {
            char ch = scanner.next().charAt(0);
            player1.move(ch);
            System.out.println("Position des aktuellen Spielers: " + player1.getPos());
        }
    }

    public static void addStartingArea(Room room) {
        room.addRoom(new Pos(5, 3), new Room(new Info("EasternRoom", "IDK")));
        room.addRoom(new Pos(0, 1), new Room(new Info("WesternRoom", "IDK")));
        room.addRoom(new Pos(3, 5), new Room(new Info("NorthernRoom", "IDK")));
    }
}