package com.floppa.Menu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import java.io.File;
import java.util.Scanner;


public class MainMenu {
    public static String mainMenu() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        SoundPlayer soundPlayer = new SoundPlayer();
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        soundPlayer.playSound(clip);

        System.out.println("1. Continue");
        System.out.println("2. Load Game");
        System.out.println("3. Save Game");
        System.out.println("4. Settings");
        System.out.println("5. Exit");
        String ret = scanner.nextLine();

        if (clip != null) {
            clip.stop();
        }

        return ret;
    }
}
