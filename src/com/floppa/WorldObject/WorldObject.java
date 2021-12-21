package com.floppa.WorldObject;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Items.Item;

import java.util.ArrayList;

/**
 * Class for implementing Objects which are static in a Room and contain Items
 */
public class WorldObject {
    private Info info;
    private Item content;
    private boolean open = false;

    /***
     * Sets the Info for the Room
     * @param info
     */
    public WorldObject(Info info) {
        this.info = info;
    }

    /**
     * Opens the Object and returns its Content
     * @return
     */
    public Item open() {
        if(!open) {
            open = true;
            return content;
        }
        System.out.println("This Container has already been opened. It's empty");
        return null;
    }

    /***
     * Adds an Item as Content to the Object
     * @param item
     */
    public void addItem(Item item) {
        content = item;
    }
}
