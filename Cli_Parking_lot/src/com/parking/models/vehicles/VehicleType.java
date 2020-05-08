package com.parking.models.vehicles;

import com.parking.models.parking.spots.SpotType;

import java.util.Arrays;
import java.util.List;

public enum VehicleType {
    GAS_CAR(Arrays.asList(SpotType.COMPACT,SpotType.LARGE)),
    ELECTRIC_CAR(Arrays.asList(SpotType.ELECTRIC)),
    TRUCK(Arrays.asList(SpotType.LARGE)),
    VAN(Arrays.asList(SpotType.LARGE)),
    MOTORCYCLE(Arrays.asList(SpotType.MOTORCYCLE,SpotType.COMPACT,SpotType.LARGE));

    private final List<SpotType> fitsIn;

    VehicleType(List<SpotType> fitsIn) {
        this.fitsIn = fitsIn;
    }

    public List<SpotType> getFitsIn() {
        return fitsIn;
    }
}
