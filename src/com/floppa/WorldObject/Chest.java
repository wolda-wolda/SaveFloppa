package com.floppa.WorldObject;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Items.Item;

import java.util.ArrayList;

public class Chest extends WorldObject implements Interaction {
    private ArrayList<Item> content;

    public Chest(Info info, ArrayList<Item> items) {
        super(info);
        this.content = items;
    }

    @Override
    public void open() {
        //makes open zhe chest
    }
}
