package com.floppa.Entity;

import com.floppa.Entity.Entity;
import com.floppa.Info;

public class Floppa extends Entity {
    private int age;
    private boolean starvin = false;
    private boolean dead = false;
    private boolean needFoodNextRound = false;

    public Floppa(Info info) {
        super(info);
    }

    public void isStarvin() {
        if (starvin) {
            System.out.println("Attention Big Floppa is starving, give him Food");

        }
        if (needFoodNextRound) {
            this.dead = true;
        } else {
            this.needFoodNextRound = true;
            this.starvin = true;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isNeedFoodNextRound() {
        return needFoodNextRound;
    }

    @Override
    public void performLevelUp() {
        System.out.println(" #############################");
        System.out.println(" # Floppa reached new Age " + (++this.age) + "! # ");
        System.out.println(" #############################");
        this.setCurrentLevel(getCurrentLevel() + 1);
        this.starvin = false;
        this.needFoodNextRound = false;
    }
}
