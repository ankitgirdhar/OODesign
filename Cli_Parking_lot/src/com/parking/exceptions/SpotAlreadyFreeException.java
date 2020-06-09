package com.parking.exceptions;

public class SpotAlreadyFreeException extends Exception {
    public SpotAlreadyFreeException(String s) {
        super(s);
    }
}
