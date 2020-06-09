package com.parking.models.accounts;

import com.parking.models.Person;

public class Admin extends Account {
    public Admin(String username, String saltedHashPassword, Person person) {
        super(username, saltedHashPassword, person);
    }

    void addFloor(Floor floor){}
    void removeFloor(Floor floor){}
    void modifyFloor(Floor floor){}

    void addSpot(Floor floor, Spot spot){}
    void removeFloor(Floor floor, Spot spot){}
    void modifyFloor(Floor floor, Spot spot){}

    void addElectronic(Floor floor, Electronics electronics){}
    void removeElectronic(Floor floor, Electronics electronics){}
    void modifyElectronic(Floor floor, Electronics electronics){}

    void addGate(Floor floor, Gate gate){}
    void removeGate(Floor floor, Gate gate){}
    void modifyGate(Floor floor, Gate gate){}

    void addAttendant(Floor floor, Attendant attendant){}
    void removeAttendant(Floor floor, Attendant attendant){}
    void modifyAttendant(Floor floor, Attendant attendant){}

}
