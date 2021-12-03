package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Position.Position;
import com.floppa.Room.Room;

public class Exit extends Room implements Interaction {
    private Room room;
    private boolean locked;
    private Position position;

    public Exit(Info info, Position position) {
        super(info);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void unlock() {

    }

    @Override
    public void open() {
        //makes open zhe door
    }
}
