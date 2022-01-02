package com.floppa.Entity;

import com.floppa.Info;

public class Enemy extends Entity {

    /**
     * Sets the Info
     *
     * @param info
     */
    public Enemy(Info info, int level) {
        super(info);
        this.setCurrentLevel(level);
    }

    public void attackPlayer() {

    }
}
