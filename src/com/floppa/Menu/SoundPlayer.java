package com.floppa.Menu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {

    public void playSound(Clip clip, String path) {

        new Thread(() -> {
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir") + path));
                clip.open(inputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
}