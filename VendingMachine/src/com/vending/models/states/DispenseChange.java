package com.vending.models.states;

import com.vending.exceptions.InvalidActionException;
import com.vending.models.VendingMachine;

public class DispenseChange implements State {
    private final VendingMachine vendingMachine;

    public DispenseChange(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) throws InvalidActionException {
        throw new InvalidActionException("Cash cannot be collected while dispensing cash!");
    }

    @Override
    public void dispenseItem(String productCode) throws InvalidActionException {
        throw new InvalidActionException("Item will be dispensed once the change amount will be dispensed!!");
    }

    @Override
    public void dispenseChange(String productCode) {
        int change = this.vendingMachine.getCollectedCash() - this.vendingMachine.getProductPriceMap().get(productCode);
        System.out.println("Change of" + change + " is returned!!");
        this.vendingMachine.setCollectedCash(0);
        this.vendingMachine.setState(new Ready(vendingMachine));
    }

    @Override
    public void cancelTransaction() throws InvalidActionException {
        throw new InvalidActionException("Wait till change gets dispensed!!");
    }
}
