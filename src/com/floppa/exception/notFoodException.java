package com.floppa.exception;

public class notFoodException extends Exception {
    @Override
    public String getMessage() {
        return "Bruv why would you eat this";
    }
}
