package com.floppa;

import com.floppa.Entity.Floppa;
import com.floppa.Entity.Player;
import com.floppa.Items.Food;
import com.floppa.Items.Item;
import com.floppa.Items.Key;
import com.floppa.Position.Pos;
import com.floppa.Room.Room;
import com.floppa.WorldObject.Chest;
import com.floppa.WorldObject.Closet;
import com.floppa.WorldObject.WorldObject;

import java.util.*;

import static com.floppa.Menu.MainMenu.mainMenu;
import static com.floppa.Menu.Menu.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Epic save floppa game have fun :D");
        Scanner scanner = new Scanner(System.in);
        String ch = "";
        Room room = new Room(new Info("StartRoom", "IDK"), false);
        Floppa floppa = new Floppa(new Info("Big Floppa", "Angy when sees Bri ish 'person'"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room, floppa);


        addStartingArea(room);
        Menu(mainMenu(), player1);
        room.printWorldObjects();
        while (!Objects.equals(ch, "exit")) {
            System.out.println("INPUT: ");
            ch = scanner.nextLine().toLowerCase();
            Menu(ch, player1);
            if (!Objects.equals(ch, "exit")) {
                System.out.println("Position of player: " + player1.getPosString());
            }
        }
    }

    public static void addStartingArea(Room room) {
        int enemies = 5, level = 1;
        ArrayList<WorldObject> allWorldObjects = new ArrayList<>();
        allWorldObjects.add(new Chest(new Info("Chest", "Chest")));
        ArrayList<Item> allItems = new ArrayList<>();
        allItems.add(new Food(new Info("apple", "apple"), 5, 5));
        allItems.add(new Key(new Info("key", "unlocks doors")));
        room.addRoom(new Pos(5, 3), new Room(new Info("EasternRoom", "IDK"), false));
        room.addRoom(new Pos(0, 3), new Room(new Info("WesternRoom", "IDK"), false));
        room.addRoom(new Pos(3, 5), new Room(new Info("EndRoom", "IDK"), true));
        room.fill(allWorldObjects, allItems);

        for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            r.getValue().addEnemy(enemies++, level++);
        }
    }
}