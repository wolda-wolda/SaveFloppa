package com.floppa.Menu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/***
 * Implements a Thread along with a Sound Player
 */
public class SoundPlayer {

    /**
     * Plays a given Sound and loops it infinitely
     *
     * @param clip
     * @param path
     */
    public void playSound(Clip clip, String path, boolean loop) {

        new Thread(() -> {
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir") + path));
                clip.open(inputStream);
                clip.start();
                if (loop) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
}