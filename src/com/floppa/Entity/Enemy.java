package com.floppa.Entity;

import com.floppa.Info;
import com.floppa.Menu.SoundPlayer;
import com.floppa.Room.Room;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import static java.lang.Thread.sleep;

/**
 * Class implementing Enemies and theActions needed for them to work
 */
public class Enemy extends Entity {

    /**
     * Sets the Info
     *
     * @param info
     */
    public Enemy(Info info, int level) {
        super(info);
        this.setCurrentLevel(level);
    }

    /**
     * Removes Player HP based on the level
     * Plays sounds
     * @param player
     * @param currentRoom
     */
    public void attackPlayer(Player player, Room currentRoom) {
        SoundPlayer soundPlayer = new SoundPlayer();
        while (player.getHp() > 0 && currentRoom.getEnemies().size() > 0) {
            player.setHp(player.getHp() - (19 - (player.getCurrentLevel() - this.getCurrentLevel())));
            currentRoom.getEnemies().remove(0);
            System.out.println("You have " + player.getHp() + " HP left and still " + currentRoom.getEnemies().size() + " Enemies to defeat");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (player.getHp() <= 0) {
            System.out.println("You died! Game over!! You should level up or heal yourself to get past this level");
            try {
                Clip clip = AudioSystem.getClip();
                soundPlayer.playSound(clip, "/Sound/gameOver.wav", false);
                sleep(2000);
            } catch (LineUnavailableException | InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        System.out.println("You defeated all the Enemies? Remember use the heal command to gain HP");
    }
}
