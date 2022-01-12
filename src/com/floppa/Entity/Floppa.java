package com.floppa.Entity;

import com.floppa.Info;
import com.floppa.Menu.SoundPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * Class for implementing a Floppa, the Player's Pet
 */
public class Floppa extends Entity {
    private int age;
    private boolean starving = false;
    private boolean dead = false;
    private boolean needFoodNextRound = false;

    /***
     * Set the Info
     * @param info
     */
    public Floppa(Info info) {
        super(info);
    }

    /**
     * Check if the Floppa is starving and print a warning if that's the case
     * If the Floppa is about to die in the next round, kill it
     * Otherwise set starving to true
     */
    public void isStarving() {
        if (starving) {
            System.out.println("Caution, Big Floppa is starving, feed him :(");

        }
        if (needFoodNextRound) {
            this.dead = true;
        } else {
            this.needFoodNextRound = true;
            this.starving = true;
        }
    }

    /**
     * Return if the Floppa is dead
     *
     * @return
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Return if the Floppa needs Food next Round
     *
     * @return
     */
    public boolean isNeedFoodNextRound() {
        return needFoodNextRound;
    }

    /**
     * Print the Level Up and reset all States such as hunger
     */
    @Override
    public void performLevelUp() {
        SoundPlayer soundPlayer = new SoundPlayer();
        System.out.println(" #############################");
        System.out.println(" # Floppa reached new Age " + (++this.age) + "! # ");
        System.out.println(" #############################");
        try {
            Clip clip = AudioSystem.getClip();
            soundPlayer.playSound(clip, "/src/Config/levelup.wav", false);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        this.setCurrentLevel(getCurrentLevel() + 1);
        this.starving = false;
        this.needFoodNextRound = false;
        this.dead = false;
    }
}
