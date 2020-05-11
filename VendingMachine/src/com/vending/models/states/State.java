package com.vending.models.states;

import com.vending.exceptions.InvalidActionException;
import com.vending.exceptions.InvalidProductCodeException;
import com.vending.exceptions.ProductOutOfStockException;

public interface State {
    public void collectCash(int cash) throws InvalidActionException;
    public void dispenseItem(String productCode) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException;
    public void dispenseChange(String productCode) throws InvalidActionException;
    public void cancelTransaction() throws InvalidActionException;
}
