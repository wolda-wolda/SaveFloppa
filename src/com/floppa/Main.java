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

public class Main {
    public static void main(String[] args) {
        System.out.println("[ENG] Welcome to Epic Floppa Gaem :D");
        Scanner scanner = new Scanner(System.in);
        String ch = "";
        Room room = new Room(new Info("StartRoom", "IDK"));
        Floppa floppa = new Floppa(new Info("Big Floppa", "Angy when sees Bri ish 'person'"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room, floppa);
        player1.levelUp(new Food(new Info("Apfel", "Macht die groß und Stark"), 10, 1));
        floppa.levelUp(new Food(new Info("Apfel", "Macht die groß und Stark"), 10, 1));
        player1.heal(new Food(new Info("Birne", "Dein HP wird steigen"), 1, 101));
        player1.heal(new Food(new Info("Apfel", "Dein HP wird steigen"), 1, 2));


        addStartingArea(room);
        room.printWorldObjects();
        while (!Objects.equals(ch, "Exit")) {
            System.out.println("INPUT: ");
            ch = scanner.next();
            player1.Menu(ch, player1);
            if (!Objects.equals(ch, "Exit")) {
                System.out.println("Position des aktuellen Spielers: " + player1.getPos());
            }
        }
    }

    public static void addStartingArea(Room room) {
        room.addRoom(new Pos(5, 3), new Room(new Info("EasternRoom", "IDK")));
        room.addRoom(new Pos(0, 3), new Room(new Info("WesternRoom", "IDK")));
        room.addRoom(new Pos(3, 5), new Room(new Info("NorthernRoom", "IDK")));

        LinkedHashMap<Pos, WorldObject> objects = new LinkedHashMap<>();
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Food(new Info("Apfel", "xdds"), 1, 10));
        objects.put(new Pos(3, 4), new Chest(new Info("Chest", "Chest"), items));
        objects.put(new Pos(3, 5), new Chest(new Info("Chest2", "Chest2"), items));
        objects.put(new Pos(1, 1), new WorldObject(new Info("TestObjekt", "Test")));
        room.fillRoom(objects);
    }
}