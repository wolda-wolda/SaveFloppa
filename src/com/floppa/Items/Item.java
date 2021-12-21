package com.floppa.Items;

import com.floppa.Info;

/**
 * Class for Implementing Items aka Objects that can be in the Player's Inventory
 */
public abstract class Item {
    Info info;
    private int count;

    /**
     * Sets the Info of the Item and its Amount to 1
     * @param info
     */
    public Item(Info info) {
        this.info = info;
        count = 1;
    }

    /**
     * Return the Item's Name
     * @return
     */
    public String getInfo(){
        return this.info.getName();
    }

    /**
     * Add 1 to the Item's Amount
     */
    public void incrementCount(){
        this.count++;
    }

    /**
     * Subtract 1 from the Item's Amount
     */
    public void decrementCount() {
        this.count--;
    }

    /**
     * Prints the Item with its properties in a readable Format
     * @return
     */
    @Override
    public String toString() {
        return info.getName() + " | " + info.getDescription() + " | " + this.count;
    }
}
