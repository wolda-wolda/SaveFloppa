package com.floppa.WorldObject;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Items.Item;

import java.util.ArrayList;

public class WorldObject {
    private Info info;
    private Item content;
    private boolean open = false;

    public WorldObject(Info info) {
        this.info = info;
    }

    public Item open() {
        if(!open) {
            open = true;
            return content;
        }
        System.out.println("This Container has already been opened. It's empty");
        return null;
    }

    public void addItem(Item item) {
        content = item;
    }
}
