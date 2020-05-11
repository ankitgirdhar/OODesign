package com.vending.models.states;

import com.vending.exceptions.InvalidActionException;
import com.vending.exceptions.InvalidProductCodeException;
import com.vending.exceptions.ProductOutOfStockException;
import com.vending.models.VendingMachine;

public class DispenseItem implements State {
    private final VendingMachine vendingMachine;

    public DispenseItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void collectCash(int cash) throws InvalidActionException {
        throw new InvalidActionException("Cannot collect cash. Wait till item is dispensed!");
    }

    @Override
    public void dispenseItem(String productCode) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException {
        if(!this.vendingMachine.getProductPriceMap().containsKey(productCode))
            throw new InvalidProductCodeException("Product code is invalid! please try again");
        int quantity = this.vendingMachine.getProductCountMap().get(productCode);
        if(quantity == 0)
            throw new ProductOutOfStockException("Selected product is out of stock!!");
        System.out.println("Collect the product from the slot below!! Enjoy!");
        this.vendingMachine.getProductCountMap().put(productCode, quantity - 1);
        this.vendingMachine.setState(new DispenseChange(vendingMachine));
        this.vendingMachine.dispenseChange(productCode);
    }

    @Override
    public void dispenseChange(String productCode) {

    }

    @Override
    public void cancelTransaction() throws InvalidActionException {

    }
}
