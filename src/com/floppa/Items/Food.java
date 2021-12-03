package com.floppa.Items;

import com.floppa.Info;
import com.floppa.Items.Item;

public class Food extends Item {
    private int strength;

    public Food(Info info) {
        super(info);
        this.strength = 100;
    }

    public int getStrength() {
        return strength;
    }
}
