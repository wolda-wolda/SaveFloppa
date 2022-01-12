package com.floppa.Entity;

import com.floppa.Info;
import com.floppa.Menu.SoundPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/***
 * Class for implementing non-static Entities
 */
public class Entity {
    private final Info info;
    private int hp = 100;
    private int currentLevel = 1;
    private int curXP = 0;
    private Map<Integer, Integer> xpPerLevel = loadXpPerLevel();

    /**
     * Sets the Info
     *
     * @param info
     */
    public Entity(Info info) {
        this.info = info;
    }

    /**
     * Returns the XP from a File
     *
     * @return
     */
    public Map<Integer, Integer> loadXpPerLevel() {
        Map<Integer, Integer> xpPerLevel = new LinkedHashMap<>();
        String file = System.getProperty("user.dir") + "/src/Config/LevelingSystem.txt";
        int level = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                xpPerLevel.put(level++, Integer.valueOf(line));
            }
        } catch (IOException e) {
            System.out.println("XP Datei konnte nicht geladen werden");
            e.printStackTrace();
        }
        return this.xpPerLevel = xpPerLevel;
    }

    /***
     * Level Up, if the current XP is enough for the next Level
     * Do nothing otherwise
     */
    public void checkCurrentXP() {
        Integer xpRequired;
        xpRequired = xpPerLevel.get(currentLevel);
        if (null != xpRequired) {
            if (curXP >= xpRequired) {
                performLevelUp();
                checkCurrentXP();
            }
        }
    }

    /**
     * Return XP loaded from File
     *
     * @return
     */
    public Map<Integer, Integer> getXpPerLevel() {
        return xpPerLevel;
    }

    /***
     * Print the Level up Information
     */
    public void performLevelUp() {
        SoundPlayer soundPlayer = new SoundPlayer();
        System.out.println(" #############################");
        System.out.println(" # Reached new level " + (++currentLevel) + "!      # ");
        System.out.println(" #############################");
        try {
            Clip clip = AudioSystem.getClip();
            soundPlayer.playSound(clip, "/src/Config/levelup.wav", false);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /***
     * Level up the Entity
     * @param player
     * @param part3
     */
    public void levelUp(Player player, String part3) {
        var tmp = player.depositFood(part3);
        if (tmp != null) {
            if (this.hp < 100) {
                this.hp += tmp.getHp();
                if (this.hp > 100) {
                    this.hp = 100;
                }
                System.out.println("you regained your HP to: " + this.hp);
            }
            System.out.println("You ate: " + tmp.getInfo());
            this.curXP += tmp.getStrength();
            checkCurrentXP();
        }
    }

    /***
     * Heal the Entity
     * @param player
     * @param part3
     */

    /***
     * Return the Entity's HP
     * @return
     */
    public int getHp() {
        return hp;
    }

    /***
     * Return the current Level
     * @return
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Return the current XP
     *
     * @return
     */
    public int getCurXP() {
        return curXP;
    }

    /**
     * Set the current XP
     *
     * @param curXP
     */
    public void setCurXP(int curXP) {
        this.curXP = curXP;
    }

    /**
     * Set the current HP
     *
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Set the current Level
     *
     * @param currentLevel
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Retyrn Info
     *
     * @return
     */
    public Info getInfo() {
        return info;
    }

    public void printInfo() {
        System.out.println("Your HP: " + this.getHp() + " your level: " + this.getCurrentLevel());
    }
}
