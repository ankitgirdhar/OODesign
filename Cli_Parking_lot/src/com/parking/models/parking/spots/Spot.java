package com.parking.models.parking.spots;

import com.parking.exceptions.MalformedVehicleException;
import com.parking.exceptions.SpotAlreadyFreeException;
import com.parking.exceptions.SpotAlreadyOccupiedException;
import com.parking.models.Auditable;
import com.parking.models.vehicles.Vehicle;

public abstract class Spot extends Auditable {
    private final SpotType spotType;
    private SpotStatus status;
    private Vehicle vehicle;

    public Spot(SpotType spotType) {
        this.spotType = spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void park(Vehicle vehicle) throws SpotAlreadyOccupiedException, MalformedVehicleException {
        if(!status.equals(SpotStatus.FREE))
            throw new SpotAlreadyOccupiedException(this.toString() + " is already occupied!!");
        if(!vehicle.getVehicleType().getFitsIn().contains(this.spotType))
            throw new MalformedVehicleException(vehicle.getVehicleType().toString() + " doesn't fit in" + this.toString());
        this.vehicle = vehicle;
        this.status = SpotStatus.OCCUPIED;
    }

    public Vehicle unPark() throws SpotAlreadyFreeException {
        if(status.equals(SpotStatus.FREE))
            throw new SpotAlreadyFreeException("spot is already free!!");
        Vehicle vehicle = this.vehicle;
        this.vehicle = null;
        this.status = SpotStatus.FREE;
        return vehicle;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "spotType=" + spotType +
                ", status=" + status +
                ", vehicle=" + vehicle +
                '}';
    }
}
