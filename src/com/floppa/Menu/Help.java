package com.floppa.Menu;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class for getting help with the current Situation a Player is in
 */
public abstract class Help {

    /***
     * Prints the Help=Page
     */
    public static void helpPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Help Page:");
        System.out.println("###########################################");
        System.out.println("Available Commands:");
        System.out.println("Movement: Press W, A, S, D");
        System.out.println("Leveling Up + Heal: Eat Player/Floppa FoodItem");
        System.out.println("Save/Load Game: Save/Load");
        System.out.println("Open: Opens WorldObject");
        System.out.println("Menu: Opens main menu");
        System.out.println("Display infos: info player/floppa/room");
        System.out.println("Show inventory: inventory");
        System.out.println("Exit: Closes game without Saving");
        System.out.println("###########################################");
        System.out.println("Press any key to proceed");
        scanner.nextLine();
        ClearConsole();
    }

    /**
     * Clears all the Text from the Console Window
     */
    public static void ClearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
