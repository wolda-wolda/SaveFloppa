package com.floppa.Items;

import com.floppa.Info;
import com.floppa.Items.Item;

public class Food extends Item {
    private int strength;
    private int hp;

    public Food(Info info, int strength, int hp) {
        super(info);
        this.strength = strength;
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public int getHp(){ return hp;}

}


