package com.parking.models.parking;

import com.parking.models.Auditable;
import com.parking.models.accounts.Attendant;
import com.parking.models.electronics.AutoExitPanel;
import com.parking.models.parking.interfaces.PaymentEnable;

public class Gate extends Auditable implements PaymentEnable {
    private GateType gateType;
    private String gateNumber;
    private Attendant attendant;
    private AutoExitPanel exitPanel;

    void open() {}
    void close() {}


    @Override
    public void processTicket(Ticket ticket) {

    }

    @Override
    public void processPayment() {

    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Attendant getAttendant() {
        return attendant;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }

    public AutoExitPanel getExitPanel() {
        return exitPanel;
    }

    public void setExitPanel(AutoExitPanel exitPanel) {
        this.exitPanel = exitPanel;
    }
}
