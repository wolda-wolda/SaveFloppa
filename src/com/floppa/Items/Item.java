package com.floppa.Items;

import com.floppa.Info;

public abstract class Item {
    Info info;
    private int count;

    public Item(Info info) {
        this.info = info;
        count++;
    }

    public String getInfo(){
        return this.info.getName();
    }

    public void incrementCount(){
        this.count++;
    }

    public void decrementCount() {
        this.count--;
    }
}
