package com.floppa.Items;

import com.floppa.Info;
import com.floppa.Items.Item;

/**
 * Class for adding Food
 */
public class Food extends Item {
    private int strength;
    private int hp;

    /**
     * Sets the Info, the Strength and the HP which the Food grants
     * @param info
     * @param strength
     * @param hp
     */
    public Food(Info info, int strength, int hp) {
        super(info);
        this.strength = strength;
        this.hp = hp;
    }

    /***
     * Returns the Strength
     * @return
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Return the HP
     * @return
     */
    public int getHp(){ return hp;}

}


