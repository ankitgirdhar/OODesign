package com.elevator;

import com.elevator.exceptions.InvalidElevatorNumberException;
import com.elevator.exceptions.InvalidFloorException;
import com.elevator.models.Elevator;
import com.elevator.models.ElevatorController;
import com.elevator.models.ElevatorRequest;

import java.util.Scanner;

public class ElevatorMain {
    public static void main(String[] args) throws InvalidElevatorNumberException, InvalidFloorException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the number of elevators you want:");
        int elevatorCount = reader.nextInt();
        System.out.println("Enter number of floors in building:");
        int floorCount = reader.nextInt();
        ElevatorController elevatorController = new ElevatorController(elevatorCount,floorCount);
        boolean start = true;
        while(start) {
            System.out.println("Select choice from below:");
            System.out.println("1. Find elevator status.");
            System.out.println("2. Schedule an elevator.");
            System.out.println("3. Exit the system.");
            int choice = reader.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter elevator number:");
                    int elevatorNumber = reader.nextInt();
                    Elevator elevator = elevatorController.getElevatorInfo(elevatorNumber);
                    System.out.println(elevator.toString());
                    break;
                case 2:
                    System.out.println("Enter start floor: ");
                    int startFloor = reader.nextInt();
                    System.out.println("Enter end floor:");
                    int endFloor = reader.nextInt();
                    ElevatorRequest elevatorRequest = new ElevatorRequest(startFloor,endFloor);
                    elevatorController.decideNext(elevatorRequest);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    start = false;
                    break;
                default:
                    System.out.println("Enter a valid choice!!");
            }
        }
    }
}
