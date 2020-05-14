package com.elevator.models;

public enum ElevatorStatus {
    IDLE(0),
    RUNNING(1),
    MAINTAINANCE(2),
    OPEN(3),
    CLOSE(4);

    private int status;


    ElevatorStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
