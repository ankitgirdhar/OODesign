package com.vending.models.states;

import com.vending.exceptions.InvalidActionException;
import com.vending.exceptions.InvalidProductCodeException;
import com.vending.exceptions.ProductOutOfStockException;
import com.vending.models.VendingMachine;

public class CancelledTransaction implements State {
    private final VendingMachine vendingMachine;

    public CancelledTransaction(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) throws InvalidActionException {
        throw new InvalidActionException("Cash cannot be collected! wait for transaction to cancel!");
    }

    @Override
    public void dispenseItem(String productCode) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException {
        throw new InvalidActionException("Item cannot be dispensed while cancelling transaction!!");
    }

    @Override
    public void dispenseChange(String productCode) throws InvalidActionException {
        throw new InvalidActionException("Change cannot be dispensed while transaction is canceled!!");
    }

    @Override
    public void cancelTransaction() throws InvalidActionException {
        System.out.println(" Returning the collected cash" + vendingMachine.getCollectedCash());
        vendingMachine.setCollectedCash(0);
        vendingMachine.setState(new Ready(vendingMachine));
    }
}
