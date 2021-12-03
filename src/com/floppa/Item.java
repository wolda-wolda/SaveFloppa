package com.floppa;

public abstract class Item {
    Info info;
    private int count;

    public Item(Info info) {
        this.info = info;
        count++;
    }
}
