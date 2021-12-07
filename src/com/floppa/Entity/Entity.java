package com.floppa.Entity;

import com.floppa.Items.Food;
import com.floppa.Info;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Entity {
    private Info info;
    private int hp;
    private int currentLevel = 1;
    private int curXP = 0;
    private Map<Integer, Integer> xpPerLevel = loadXpPerLevel();

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

    private void checkCurrentXP() {
        Integer xpRequired;
        xpRequired = xpPerLevel.get(currentLevel);
        if (null != xpRequired) {
            if (curXP >= xpRequired) {
                performLevelUp();
                checkCurrentXP();
            }
        }
    }

    private void performLevelUp() {
        System.out.println(" #############################");
        System.out.println(" # Neues Level erreicht " + (++currentLevel) + "!   # ");
        System.out.println(" #############################");
    }

    public void levelUp(Food food) {
        this.curXP += food.getStrength();
        checkCurrentXP();
    }

    public void heal(Food food) {

        if(this.hp < 100){
            this.hp += food.getHp();
                if(this.hp > 100){
                    this.hp = 100;
                }
            System.out.println("Erfolgreich " + food.getInfo() + " hat HP von " + this.hp);
        }
    }
}
