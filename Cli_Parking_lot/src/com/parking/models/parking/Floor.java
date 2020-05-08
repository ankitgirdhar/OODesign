package com.parking.models.parking;

import com.parking.exceptions.MalformedVehicleException;
import com.parking.exceptions.SpotAlreadyFreeException;
import com.parking.exceptions.SpotAlreadyOccupiedException;
import com.parking.exceptions.SpotNotAddedException;
import com.parking.models.Auditable;
import com.parking.models.accounts.Customer;
import com.parking.models.electronics.CustomerInfoPortal;
import com.parking.models.electronics.DisplayBoard;
import com.parking.models.parking.spots.Spot;
import com.parking.models.parking.spots.SpotStatus;
import com.parking.models.parking.spots.SpotType;
import com.parking.models.vehicles.Vehicle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Floor extends Auditable {
    private CustomerInfoPortal customerInfoPortal;
    private DisplayBoard displayBoard;
    private String name;
    private Map<SpotType, Set<Spot>> freeSpots;
    private Map<SpotType, Set<Spot>> occupiedSpots;

    public Floor(String name) {
        this.name = name;
        displayBoard = new DisplayBoard();
        freeSpots = new HashMap<>();
        occupiedSpots = new HashMap<>();
        customerInfoPortal = new CustomerInfoPortal();
    }

    private void populateMap(SpotType type) {
        if(!freeSpots.containsKey(type))
            freeSpots.put(type, new HashSet<>());
        if(!occupiedSpots.containsKey(type))
            occupiedSpots.put(type, new HashSet<>());
    }

    public void addSpot(Spot spot) throws SpotAlreadyOccupiedException {
        populateMap(spot.getSpotType());
        if(!spot.getStatus().equals(SpotStatus.FREE) || occupiedSpots.get(spot.getSpotType()).contains(spot))
            throw new SpotAlreadyOccupiedException("Can't move" + spot.toString() + "because it is already occupied!!");
        freeSpots.get(spot.getSpotType()).add(spot);
    }

    public synchronized void park(Spot spot, Vehicle vehicle) throws SpotNotAddedException, MalformedVehicleException, SpotAlreadyOccupiedException {
        populateMap(spot.getSpotType());
        if(!freeSpots.get(spot.getSpotType()).contains(spot))
            throw new SpotNotAddedException("Spot is not added or not available for parking!!");
        spot.park(vehicle);
        freeSpots.get(spot.getSpotType()).remove(spot);
        occupiedSpots.get(spot.getSpotType()).add(spot);
        updateDisplayBoard();
    }

    public synchronized Vehicle unPark(Spot spot) throws SpotNotAddedException, SpotAlreadyFreeException {
        populateMap(spot.getSpotType());
        if(!occupiedSpots.get(spot.getSpotType()).contains(spot))
            throw new SpotNotAddedException("Spot is not found for unparking!!");
        Vehicle vehicle = spot.unPark();
        occupiedSpots.get(spot.getSpotType()).remove(spot);
        freeSpots.get(spot.getSpotType()).add(spot);
        updateDisplayBoard();
        return vehicle;
    }

    public void updateDisplayBoard() {
        StringBuilder message = new StringBuilder();
        message.append(this.toString()).append("\n");
        for(SpotType type : freeSpots.keySet()) {
            Set<Spot> spots = freeSpots.get(type);
            message.append("\n").append(type.toString()).append(": ");
            if(spots.size() == 0)
                message.append("no free spots :(");
            else
                message.append(spots.iterator().next().toString());
        }
        displayBoard.showDisplay(message.toString());
    }

    public CustomerInfoPortal getCustomerInfoPortal() {
        return customerInfoPortal;
    }

    public void setCustomerInfoPortal(CustomerInfoPortal customerInfoPortal) {
        this.customerInfoPortal = customerInfoPortal;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<SpotType, Set<Spot>> getFreeSpots() {
        return freeSpots;
    }

    public void setFreeSpots(Map<SpotType, Set<Spot>> freeSpots) {
        this.freeSpots = freeSpots;
    }

    public Map<SpotType, Set<Spot>> getOccupiedSpots() {
        return occupiedSpots;
    }

    public void setOccupiedSpots(Map<SpotType, Set<Spot>> occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "name='" + name + '\'' +
                '}';
    }
}
