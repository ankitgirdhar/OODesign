package com.elevator.models;

import com.elevator.exceptions.InvalidElevatorNumberException;
import com.elevator.exceptions.InvalidFloorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevatorList;
    private Direction direction;
    private int floorCount;

    public ElevatorController(List<Elevator> elevatorList, Direction direction, int floorCount) {
        this.elevatorList = elevatorList;
        this.direction = direction;
        this.floorCount = floorCount;
    }

    public ElevatorController(int elevatorCount, int floorCount) {
        this.elevatorList = new ArrayList<>(elevatorCount);
        this.floorCount = floorCount;
        createElevators(elevatorCount);
    }

    private void createElevators(int elevatorCount) {
        for(int i=0;i<elevatorCount ;i++) {
            Elevator elevator = new Elevator(i+1);
            elevatorList.add(elevator);
            elevator.start();
        }
    }

    public void stopAllElevators() throws InterruptedException {
        for(Elevator e : elevatorList)
        {
            if(e.isAlive())
            {
                System.out.println("Stopping elevator: " + e.getElevatorNumber());
                e.setShouldExit(true);
                e.join();
            }
        }
    }


    public synchronized void decideNext(ElevatorRequest elevatorRequest) throws InvalidFloorException {
        int constDiff = 2;
        int startFloor = elevatorRequest.getStartFloor();
        int endFloor = elevatorRequest.getEndFloor();

        if(startFloor > floorCount || startFloor < 1 || endFloor > floorCount || endFloor < 1)
            throw new InvalidFloorException("start and/or end floor provided is invalid!!");

        if( startFloor > endFloor)
            direction = Direction.DOWN;
        else
            direction = Direction.UP;
        int minDiff = Integer.MAX_VALUE;
        Elevator chosenElevator = null;
        List<Integer> floors = new ArrayList<>(Arrays.asList(startFloor,endFloor));

        while(true) {
            chosenElevator = null;
            for(Elevator elevator : elevatorList) {

                int currDiff = 0;
                if((elevator.getDirection() == Direction.NONE) || elevator.getDirection() == direction) {

                    if(elevator.getDirection() == Direction.NONE) {
                        currDiff = Math.abs(startFloor - elevator.getCurrentFloor());
                    } else if(( direction == Direction.UP ) && (elevator.getDirection() == Direction.UP)) {
                        currDiff = startFloor - elevator.getCurrentFloor();

                        if(currDiff <= constDiff)
                            continue;
                    } else if(( direction == Direction.DOWN ) && (elevator.getDirection() == Direction.DOWN)) {
                        currDiff = elevator.getCurrentFloor() - startFloor;
                        if(currDiff <= constDiff)
                            continue;
                    }
                }

                minDiff = Math.min(minDiff, currDiff);
                if(minDiff == currDiff)
                    chosenElevator = elevator;
            }

            if(chosenElevator != null) {
                System.out.println("Elevator chosen: " + chosenElevator.toString());
                chosenElevator.addFloors(floors,direction);
                chosenElevator.setElevatorStatus(ElevatorStatus.RUNNING);
                break;
            }
        }
    }

    public Elevator getElevatorInfo(int elevatorNum) throws InvalidElevatorNumberException {
        if(elevatorList == null) return  null;
        if(elevatorNum > elevatorList.size() || elevatorNum < 1)
            throw new InvalidElevatorNumberException("Enter valid elevator number!!");

        return elevatorList.get(elevatorNum - 1);
    }
}
