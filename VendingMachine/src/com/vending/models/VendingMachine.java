package com.vending.models;

import com.vending.exceptions.InvalidActionException;
import com.vending.exceptions.InvalidProductCodeException;
import com.vending.exceptions.ProductOutOfStockException;
import com.vending.models.states.State;

import java.util.Map;

public class VendingMachine {
    private int collectedCash;
    private State state;
    private Map<String, Integer> productCountMap;
    private Map<String, Integer> productPriceMap;

    public void dispenseChange(String productCode) throws InvalidActionException {
        this.state.dispenseChange(productCode);
    }

    public void collectCash(int cash) throws InvalidActionException {
        this.state.collectCash(cash);
    }
    public void dispenseItem(String productCode) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException {
        this.state.dispenseItem(productCode);
    }

    public void cancelTransaction() throws InvalidActionException {
        this.state.cancelTransaction();
    }

    public int getCollectedCash() {
        return collectedCash;
    }

    public void setCollectedCash(int collectedCash) {
        this.collectedCash = collectedCash;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Map<String, Integer> getProductCountMap() {
        return productCountMap;
    }

    public void setProductCountMap(Map<String, Integer> productCountMap) {
        this.productCountMap = productCountMap;
    }

    public Map<String, Integer> getProductPriceMap() {
        return productPriceMap;
    }

    public void setProductPriceMap(Map<String, Integer> productPriceMap) {
        this.productPriceMap = productPriceMap;
    }
}
