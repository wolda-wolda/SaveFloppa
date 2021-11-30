package com.floppa;

import java.util.ArrayList;

public class Player extends  Entity {
    private ArrayList<WorldObject> inventory = new ArrayList<WorldObject>();
    private Position pos;

    void grabWorldObject() {
        //Add Item to Inventory
    }

    void depositWorldObject() {
        //Drop or put an Item somewhere
    }

    Position getPos() {
        return pos;
    }
}
