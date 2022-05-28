package com.elevator.models;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Elevator extends Thread {
    private boolean shouldExit = false;

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    private ElevatorStatus elevatorStatus;
    private int currentFloor;
    private TreeSet<Integer> nextUpFloors;
    private TreeSet<Integer> nextDownFloors;
    private Direction direction;
    private int elevatorNumber;
    private int DEFAULT_SLEEP_TIME = 2000;

    public Elevator(int elevatorNumber) {
        elevatorStatus = ElevatorStatus.IDLE;
        nextUpFloors = new TreeSet<>();
        nextDownFloors = new TreeSet<>(Collections.reverseOrder());
        currentFloor = 0;
        direction = Direction.NONE;
        this.elevatorNumber = elevatorNumber;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public TreeSet<Integer> getNextUpFloors() {
        return nextUpFloors;
    }

    public TreeSet<Integer> getNextDownFloors() {
        return nextDownFloors;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public void ServiceFloor(int elevatorNumber, int currentFloor, Direction direction) {
        try {
            elevatorStatus = ElevatorStatus.OPEN;
            System.out.println("Elevator:" + elevatorNumber + " Status:" + elevatorStatus + " currentFloor: " + currentFloor + " direction:" + direction);
            Thread.sleep(DEFAULT_SLEEP_TIME);  // wait while opened..
            elevatorStatus = ElevatorStatus.CLOSE;
            System.out.println("Elevator:" + elevatorNumber + " Status:" + elevatorStatus + " currentFloor: " + currentFloor + " direction:" + direction);
            Thread.sleep(DEFAULT_SLEEP_TIME); // wait while closed..
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void move() {
        try {

            while(!nextDownFloors.isEmpty()) {
                elevatorStatus = ElevatorStatus.RUNNING;
                direction = Direction.DOWN;

                if( currentFloor < nextDownFloors.first())
                    currentFloor++;
                else
                    currentFloor--;
                System.out.println("Elevator:" + elevatorNumber + " Status:" + elevatorStatus + " currentFloor: " + currentFloor + " direction:" + direction + " nextFloors:" + nextDownFloors.toString());
                Thread.sleep(DEFAULT_SLEEP_TIME);
                if( currentFloor == nextDownFloors.first())
                {
                    nextDownFloors.pollFirst();
                    ServiceFloor(elevatorNumber, currentFloor, direction);
                }
            }

            while (!nextUpFloors.isEmpty()) {
                elevatorStatus = ElevatorStatus.RUNNING;
                direction = Direction.UP;
                if( currentFloor < nextUpFloors.first())
                    currentFloor++;
                else
                    currentFloor--;
                System.out.println("Elevator:" + elevatorNumber + " Status:" + elevatorStatus + " currentFloor: " + currentFloor + " direction:" + direction + " nextFloors:" + nextUpFloors.toString());
                Thread.sleep(DEFAULT_SLEEP_TIME);
                if( currentFloor == nextUpFloors.first())
                {
                    nextUpFloors.pollFirst();
                    ServiceFloor(elevatorNumber, currentFloor, direction); // todo:doubt on who sets elevator number!!
                }
            }

            if(nextUpFloors.isEmpty() && nextDownFloors.isEmpty()) {
                elevatorStatus = ElevatorStatus.IDLE;
                direction = Direction.NONE;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addFloors(List<Integer> floors, Direction direction) { // todo: doubt on who is deciding direction while adding floors
        for(int floor : floors) {
            if(direction == Direction.DOWN)
                nextDownFloors.add(floor);
            else if(direction == Direction.UP)
                nextUpFloors.add(floor);
        }
    }

    public void setElevatorStatus(ElevatorStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(shouldExit)
                    break;

                if( elevatorStatus != ElevatorStatus.MAINTAINANCE) {
                    move();
                }

                Thread.sleep(DEFAULT_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "elevatorStatus=" + elevatorStatus +
                ", currentFloor=" + currentFloor +
                ", nextUpFloors=" + nextUpFloors +
                ", nextDownFloors=" + nextDownFloors +
                ", direction=" + direction +
                '}';
    }
}
