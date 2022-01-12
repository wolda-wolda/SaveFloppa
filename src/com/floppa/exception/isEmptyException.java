package com.floppa.exception;

public class isEmptyException extends Exception {
    @Override
    public String getMessage() {
        return "This Container has already been opened. It's empty";
    }
}
