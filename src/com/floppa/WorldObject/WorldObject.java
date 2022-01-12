package com.floppa.WorldObject;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Items.Item;
import com.floppa.exception.isEmptyException;

import java.util.ArrayList;

/**
 * Class for implementing Objects which are static in a Room and contain Items
 */
public class WorldObject implements Interaction {
    private Info info;
    private ArrayList<Item> content;
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
     *
     * @return
     */
    @Override
    public Item open() {
        if (!open) {
            if (content.size() > 0) {
                return content.remove(0);
            } else {
                open = true;
                return null;
            }
        }
        try {
            throw new isEmptyException();
        } catch (isEmptyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void unlock(Item key) {
    }

    /***
     * Adds an Item as Content to the Object
     * @param item
     */
    public void addItem(ArrayList<Item> item) {
        this.content = item;
    }
}
