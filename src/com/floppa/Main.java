package com.floppa;

import com.floppa.Entity.Floppa;
import com.floppa.Entity.Player;
import com.floppa.Items.Flower;
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
        Room room = new Room(new Info("StartRoom", "IDK"), false, "", "", true);
        Floppa floppa = new Floppa(new Info("Big Floppa", "Angy when sees Bri ish 'person'"));
        Player player1 = new Player(new Info("Kimran Saur", "Must protect Floppa"), room, floppa);


        addStartingArea(room);
        Menu(mainMenu(), player1);
        System.out.println("On a sunny day Woldi was walking peacefully down an abandoned street.\n" +
                "Suddenly he heard some weird noises coming from a house.\n" +
                "Woldi as usual got curious and moved towards the house.\n" +
                "He tried pushing the door a few times but wasn’t successful at it.\n" +
                "Then he took some steps back and ran into the door.\n" +
                "But someone had other plans for him. The wooden door got opened from the inside\n" +
                "There was a chest in the middle of the room maybe he should open it\n");
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
        allItems.add(new Food(new Info("apple", "apple"), 2, 50));
        allItems.add(new Key(new Info("key", "unlocks doors")));
        room.addRoom(new Pos(5, 3), new Room(new Info("SecondRoom", "IDK"), true, "In this room is a chaos. You picked up the empty basket.\nAdd Big Floppa’s food and toys in it.\nAnd especially flowers because Floppa loves flowers.", null, true));
        room.addRoom(new Pos(0, 3), new Room(new Info("ThirdRoom", "IDK"), true, "Big Floppa didn’t eat since a few days. Feed him. With the meat you found earlier\n", null, false));
        room.addRoom(new Pos(3, 5), new Room(new Info("ForuthRoom", "IDK"), true, "After entering the last room, you finally see the villain who stole Floppa's flopps.\nFight him!", "a", false));
        room.fill(allWorldObjects, allItems);

        /*for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            allItems.clear();
            switch (r.getValue().getInfo().getName()) {
                case "SecondRoom" -> {
                    allItems.add(new Flower(new Info("flower", "floppa loves them")));
                    allItems.add(new Food(new Info("meat", "meat tastes good"), 5, 100));
                    r.getValue().fill(allWorldObjects, allItems);
                }
                case "ThirdRoom" -> {
                    allItems.add(new Key(new Info("key", "golden key")));
                    r.getValue().fill(allWorldObjects, allItems);
                }
            }
        }
         */
        for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            r.getValue().addEnemy(enemies++, level++);
        }
    }
}