package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Position.Pos;

public class Exit extends Room implements Interaction {
    private Room room;
    private boolean locked;
    private Pos position;

    public Exit(Info info, Pos position) {
        super(info);
        this.position = position;
    }

    public Pos getPosition() {
        return position;
    }

    public void unlock() {

    }

    @Override
    public void open() {
        //makes open zhe door
    }
}
