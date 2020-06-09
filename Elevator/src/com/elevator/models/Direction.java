package com.elevator.models;

public enum Direction {
    UP(0),
    DOWN(1),
    NONE(2);

    int direction;


    Direction(int direction) {
        this.direction = direction;
    }
}
