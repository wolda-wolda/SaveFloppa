package com.floppa.Entity;

import com.floppa.Items.Food;
import com.floppa.Info;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Entity {
    private final Info info;
    private int hp;
    private int currentLevel = 1;
    private int curXP = 0;
    private Map<Integer, Integer> xpPerLevel = loadXpPerLevel();

    public Entity(Info info) {
        this.info = info;
    }

    public Map<Integer, Integer> loadXpPerLevel() {
        Map<Integer, Integer> xpPerLevel = new LinkedHashMap<>();
        String file = "src/Config/LevelingSystem.txt";
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

    public Map<Integer, Integer> getXpPerLevel() {
        return xpPerLevel;
    }

    public void performLevelUp() {
        System.out.println(" #############################");
        System.out.println(" # Neues Level erreicht " + (++currentLevel) + "!   # ");
        System.out.println(" #############################");
    }

    public void levelUp(Player player, String part3) {
        var tmp = player.depositFood(part3);
        if (tmp != null) {
            this.curXP += tmp.getStrength();
            checkCurrentXP();
        }
    }

    public void heal(Player player, String part3) {
        var tmp = player.depositFood(part3);
        if (tmp != null) {
            if (this.hp < 100) {
                this.hp += tmp.getHp();
                if (this.hp > 100) {
                    this.hp = 100;
                }
                System.out.println("Erfolgreich " + tmp.getInfo() + " hat HP von " + this.hp);
            }
        }
    }

    public int getHp() {
        return hp;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurXP() {
        return curXP;
    }

    public void setCurXP(int curXP) {
        this.curXP = curXP;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
