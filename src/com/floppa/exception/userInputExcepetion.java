package com.floppa.exception;

/**
 * Exception for handling unrecognized Inputs
 */
public class userInputExcepetion extends Exception {
    @Override
    public String getMessage() {
        return "Command not recognised! Need help? Use the help command if you want to return to Main Menu use the menu command";
    }
}
