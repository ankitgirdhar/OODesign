package com.parking.models.accounts;

import com.parking.models.Person;
import com.parking.models.parking.Ticket;
import com.parking.models.parking.interfaces.IssuesTicket;
import com.parking.models.parking.interfaces.PaymentEnable;

public class Attendant extends Account implements IssuesTicket, PaymentEnable {

    public Attendant(String username, String saltedHashPassword, Person person) {
        super(username, saltedHashPassword, person);
    }

    @Override
    public Ticket giveTicket() {
        return null;
    }

    @Override
    public void processTicket(Ticket ticket) {

    }

    @Override
    public void processPayment() {

    }
}
