package com.floppa;

import com.floppa.Entity.Floppa;
import com.floppa.Entity.Player;
import com.floppa.Items.Food;
import com.floppa.Items.Item;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;
import com.floppa.WorldObject.Chest;
import com.floppa.WorldObject.WorldObject;

import java.util.*;

import static com.floppa.Menu.Menu.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        Scanner scanner = new Scanner(System.in);
        String ch = "";
        Room room = new Room(new Info("StartRoom", "IDK"));
        Floppa floppa = new Floppa(new Info("Big Floppa", "Angy when sees Bri ish 'person'"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room, floppa);
        player1.heal(new Food(new Info("Birne", "Dein HP wird steigen"), 1, 101));
        player1.heal(new Food(new Info("Apfel", "Dein HP wird steigen"), 1, 2));


        addStartingArea(room);
        room.printWorldObjects();
        player1.getInventory().print();
        while (!Objects.equals(ch, "Exit")) {
            System.out.println("INPUT: ");
            ch = scanner.nextLine();
            Menu(ch, player1);
            if (!Objects.equals(ch, "Exit")) {
                System.out.println("Position des aktuellen Spielers: " + player1.getPosString());
            }
        }
    }

    public static void addStartingArea(Room room) {
        ArrayList<WorldObject> allWorldObjects = new ArrayList<>();
        allWorldObjects.add(new WorldObject(new Info("Chest", "Chest")));
        ArrayList<Item>allItems = new ArrayList<>();
        allItems.add(new Food(new Info("Apple", "Apple"), 5, 5));
        room.addRoom(new Pos(5, 3), new Room(new Info("EasternRoom", "IDK")));
        room.addRoom(new Pos(0, 3), new Room(new Info("WesternRoom", "IDK")));
        room.addRoom(new Pos(3, 5), new Room(new Info("NorthernRoom", "IDK")));
        room.fill(allWorldObjects, allItems);
    }
}