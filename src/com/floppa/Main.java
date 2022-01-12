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
        System.out.println("Welcome to Epic save floppa game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello player, please tell me your name:");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + " have fun :D");
        String ch = "";
        Room room = new Room(new Info("StartRoom", "IDK"), false, "", true);
        Floppa floppa = new Floppa(new Info("Big Floppa", "Angy when sees Bri ish 'person'"));
        Player player1 = new Player(new Info(name, "Must retreive Floppas ear"), room, floppa);


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
        room.addRoom(new Pos(5, 3), new Room(new Info("SecondRoom", "IDK"), true, "In this room is a chaos. You picked up the empty basket.\nAdd Big Floppa’s food and toys in it.\nAnd especially flowers because Floppa loves flowers.", true));
        room.addRoom(new Pos(0, 3), new Room(new Info("ThirdRoom", "IDK"), true, "Big Floppa didn’t eat since a few days. Feed him. With the meat you found earlier\n", false));
        room.addRoom(new Pos(3, 5), new Room(new Info("FourthRoom", "IDK"), true, "After entering the last room, you finally see the villain who stole Floppa's flopps.\nFight him!", false));
        String [] tmp = {"apple", "key"};
        room.fill(tmp);

        for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            r.getValue().addEnemy(enemies++, level++);
        }
        for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            switch (r.getValue().getInfo().getName()) {
                case "SecondRoom" -> {
                    String [] tmp1 = {"apple", "meat", "flower"};
                    r.getValue().fill(tmp1);
                }
                case "ThirdRoom" -> {
                    String [] tmp1 = {"apple", "meat", "golden key"};
                    r.getValue().fill(tmp1);
                }
            }
        }
    }
}