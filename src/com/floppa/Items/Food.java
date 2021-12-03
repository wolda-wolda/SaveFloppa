package com.floppa.Items;

import com.floppa.Info;
import com.floppa.Items.Item;

public class Food extends Item {
    private int strength;

    public Food(Info info, int strength) {
        super(info);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
