package com.parking.models.accounts;

import com.parking.models.Auditable;
import com.parking.models.Person;
import com.parking.models.parking.Ticket;

public class Customer extends Account {
    public Customer(String username, String saltedHashPassword, Person person) {
        super(username, saltedHashPassword, person);
    }

    public Ticket getTicket() { return null;}

    public void payForTicket(Ticket ticket) {}
}
