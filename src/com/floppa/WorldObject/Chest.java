package com.floppa.WorldObject;

import com.floppa.Interaction;
import com.floppa.Items.Item;

import java.util.ArrayList;

public class Chest extends WorldObject implements Interaction {
    private ArrayList<Item> content = new ArrayList<>();

    @Override
    public void open() {
        //makes open zhe chest
    }
}
