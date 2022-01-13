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
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println("Welcome to Epic save floppa game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello player, please tell me your name:");
        String name = scanner.nextLine();
        System.out.println("\nHello " + name + " have fun :D");
        String ch = "";
        Room room = new Room(new Info("StartRoom", "IDK"), false, "", true);
        Floppa floppa = new Floppa(new Info("Big Floppa", "Angy when sees Bri ish 'person'"));
        Player player1 = new Player(new Info(name, "Must retreive Floppas ear"), room, floppa);
        player1.setStartRoom(room);

        addStartingArea(room);
        Menu(mainMenu(), player1);
        System.out.println("On a sunny day you were walking peacefully down an abandoned street.\n" +
                "Suddenly you heard some weird noises coming from a house.\n" +
                "You got curious and moved towards the house.\n" +
                "You tried pushing the door a few times but weren’t successful at it.\n" +
                "Then you took some steps back and ran into the door.\n" +
                "But someone had other plans for you. The wooden door got opened from the inside\n");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("You slowly looked up and got shocked. He saw a big floopa, but, but something is missing you thought.\n" +
                "You examined the floppa carefully and noticed his flopps(funny ears) were missing. \n" +
                "You saw a letter attached on floppas fell. He carefully detached it. \n" +
                "You started reading the letter and found out that he has been chosen to save Big Floppa.\n" +
                "So, you decided to take floppa home with him. You reach out to Big Floppa but then he’s gone.\n" +
                "Damn it, you think. Now you have to search for him. \n" +
                "There is a chest in the room maybe you should open it\n");
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
        room.addRoom(new Pos(5, 3), new Room(new Info("SecondRoom", "Room with chest with Floppas things in it"), true, "\nAfter entering this room you found Floppa again.\nIn this room is a chaos. You picked up the empty basket.\nAdd Big Floppa’s food and toys in it.\nDon't forget his flowers because Floppa loves flowers.\nIt's a gift for the love of his life\n", true));
        room.addRoom(new Pos(0, 3), new Room(new Info("ThirdRoom", "Room with a rare golden key"), false, "\nBig Floppa didn’t eat since a few days. Feed him. With the meat you found earlier\n", false));
        room.addRoom(new Pos(3, 5), new Room(new Info("FourthRoom", "Endboss room"), true, "\nAfter entering the last room, you finally see the villain Pax(Bri ish 'person' floppa hates them) who stole Floppa's flopps.\nFight him!\n", false));
        String[] tmp = {"apple", "meat", "apple", "key"};
        room.fill(tmp);

        for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            r.getValue().addEnemy(enemies, level++);
        }
        for (HashMap.Entry<String, Room> r : room.getRooms().entrySet()) {
            switch (r.getValue().getInfo().getName()) {
                case "SecondRoom" -> {
                    String[] tmp1 = {"apple", "meat", "flower"};
                    r.getValue().fill(tmp1);
                }
                case "ThirdRoom" -> {
                    String[] tmp1 = {"apple", "meat", "meat", "golden key"};
                    r.getValue().fill(tmp1);
                }
            }
        }
    }
}
