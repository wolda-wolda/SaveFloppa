package com.floppa.exception;

public class wallException extends Exception {
    @Override
    public String getMessage() {
        return "Bonk you hit the wall there is no where to go";
    }
}
