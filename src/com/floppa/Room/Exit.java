package com.floppa.Room;

import com.floppa.Info;
import com.floppa.Interaction;
import com.floppa.Position.Pos;

/**
 * Implements an Exit, so a Door to access other Rooms
 */
public class Exit extends Room implements Interaction {
    private Room room;
    private boolean locked;
    private Pos position;

    /**
     * Sets the Info and Position
     * @param info
     * @param position
     */
    public Exit(Info info, Pos position) {
        super(info);
        this.position = position;
    }

    /**
     * Returns the Position
     * @return
     */
    public Pos getPosition() {
        return position;
    }

    /**
     * Unlocks the Exit, making the Room linked to it accessible
     */
    public void unlock() {

    }

    /**
     * Opens the Door, bringing the Player to another Room
     */
    @Override
    public void open() {
        //makes open zhe door
    }
}
