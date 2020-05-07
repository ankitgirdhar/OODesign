package com.splitwise.exceptions;

public class InvalidCommandFormatException extends Exception {

    public InvalidCommandFormatException(String unrecognised_command) {
        super(unrecognised_command);
    }
}
