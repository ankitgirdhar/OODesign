package com.parking.models.vehicles;

import com.parking.models.Auditable;
import com.parking.models.parking.Ticket;

public abstract class Vehicle extends Auditable {

    private String number;
    private String color;
    private VehicleType vehicleType;
    private Ticket ticket;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Ticket showTicket() {
        return ticket;
    }

    public void assignTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number='" + number + '\'' +
                ", color='" + color + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
