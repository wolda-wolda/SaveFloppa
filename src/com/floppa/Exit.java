package com.floppa;

public class Exit extends Room implements Interaction {
    private Room room;
    private boolean locked;

    public Exit(Info info) {
        super(info);
    }

    public void unlock() {

    }

    @Override
    public void open() {
        //makes open zhe door
    }
}
