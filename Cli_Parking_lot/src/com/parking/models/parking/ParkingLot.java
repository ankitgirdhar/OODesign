package com.parking.models.parking;

import com.parking.models.Auditable;
import com.parking.models.electronics.EntrancePanel;

import java.util.List;

public class ParkingLot extends Auditable {
    List<Floor> floorList;
    List<Gate> gateList;
    EntrancePanel entrancePanel;

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public EntrancePanel getEntrancePanel() {
        return entrancePanel;
    }

    public void setEntrancePanel(EntrancePanel entrancePanel) {
        this.entrancePanel = entrancePanel;
    }
}
