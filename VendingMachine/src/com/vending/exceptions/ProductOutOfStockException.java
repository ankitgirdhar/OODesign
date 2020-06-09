package com.vending.exceptions;

public class ProductOutOfStockException extends Exception {
    public ProductOutOfStockException(String s) {
        super(s);
    }
}
