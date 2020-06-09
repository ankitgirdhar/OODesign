package com.parking.models.parking.interfaces;

import com.parking.models.parking.Ticket;

public interface PaymentEnable {
    public void processTicket(Ticket ticket);
    public void processPayment();
}
