package com.vending;

import com.vending.exceptions.InvalidActionException;
import com.vending.exceptions.InvalidProductCodeException;
import com.vending.exceptions.ProductOutOfStockException;
import com.vending.models.VendingMachine;

import java.util.Scanner;

public class VendingController {
    public static void main(String[] args) throws InvalidActionException, InvalidProductCodeException, ProductOutOfStockException {

        VendingMachine vendingMachine = new VendingMachine();

        // put chips
        vendingMachine.getProductCountMap().put("chips",5);
        vendingMachine.getProductPriceMap().put("chips",10);

        // put coke
        vendingMachine.getProductCountMap().put("coke",15);
        vendingMachine.getProductPriceMap().put("coke",40);

        // put biscuits
        vendingMachine.getProductCountMap().put("marie",10);
        vendingMachine.getProductPriceMap().put("marie",30);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("enter the cash amount:");
            System.out.println(">");
            String cash = scanner.nextLine();
            vendingMachine.collectCash(Integer.parseInt(cash));

            System.out.println("Cash amount: " + cash + " is collected. Now enter product code!");
            System.out.println(">");

            String code = scanner.nextLine();
            vendingMachine.dispenseItem(code);
        }





    }
}
