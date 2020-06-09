package com.splitwise;

import com.splitwise.command.CommandFactory;
import com.splitwise.exceptions.*;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) throws NoSuchUserException, InvalidSplitTypeException, InvalidSplitsTotalException, InvalidExpenseTypeException {
        // write your code here
        System.out.println("Commands you can try:-");
        System.out.println("show");
        System.out.println("show UserID");
        System.out.println("show userEmail");
        System.out.println("add_user name email password");
        System.out.println("add_expense expenseType(equal,percent,exact) name totalAmount createdBy paidBy [splits(name amount)]");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(">");
            String[] cmd = sc.nextLine().split(" ");
            try {
                CommandFactory.getInstance().execute(cmd);
            } catch (InvalidCommandFormatException e) {
                System.out.println(e);
            }

        }

    }
}
