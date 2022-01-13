package com.floppa.exception;

/**
 * Exception handling the Player reaching a wall, the end of the Room
 */
public class wallException extends Exception {
    @Override
    public String getMessage() {
        return "Bonk you hit the wall there is no where to go";
    }
}
