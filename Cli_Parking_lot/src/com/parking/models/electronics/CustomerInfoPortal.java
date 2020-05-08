package com.parking.models.electronics;

import com.parking.models.parking.Ticket;
import com.parking.models.parking.interfaces.PaymentEnable;

public class CustomerInfoPortal extends Electronics implements PaymentEnable {
    @Override
    public void processTicket(Ticket ticket) {

    }

    @Override
    public void processPayment() {

    }
}
