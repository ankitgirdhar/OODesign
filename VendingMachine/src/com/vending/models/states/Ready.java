package com.vending.models.states;

import com.vending.exceptions.InvalidActionException;
import com.vending.exceptions.InvalidProductCodeException;
import com.vending.exceptions.ProductOutOfStockException;
import com.vending.models.VendingMachine;

import java.util.Scanner;

public class Ready implements State {
    private final VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException {
        this.vendingMachine.setCollectedCash(cash);
    }

    @Override
    public void dispenseItem(String productCode) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException {
        this.vendingMachine.setState( new DispenseItem(vendingMachine));
        this.vendingMachine.dispenseItem(productCode);
    }

    @Override
    public void dispenseChange(String productCode) throws InvalidActionException {
        throw new InvalidActionException("add cash first to dispense change!!");
    }

    @Override
    public void cancelTransaction() throws InvalidActionException {
        this.vendingMachine.setState(new CancelledTransaction(vendingMachine));
        this.vendingMachine.cancelTransaction();
    }
}
