package com.parking.models.electronics;

import com.parking.models.parking.Ticket;
import com.parking.models.parking.interfaces.HasDisplay;
import com.parking.models.parking.interfaces.IssuesTicket;

public class EntrancePanel extends Electronics implements HasDisplay, IssuesTicket {
    @Override
    public void showDisplay(String message) {

    }

    @Override
    public Ticket giveTicket() {
        return null;
    }
}
