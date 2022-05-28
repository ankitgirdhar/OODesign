package com.splitwise.command;

import com.splitwise.BookKeeper;
import com.splitwise.Utils;
import com.splitwise.exceptions.InvalidExpenseTypeException;
import com.splitwise.exceptions.InvalidSplitTypeException;
import com.splitwise.exceptions.InvalidSplitsTotalException;
import com.splitwise.exceptions.NoSuchUserException;
import com.splitwise.models.User;
import com.splitwise.models.expenses.Expense;
import com.splitwise.models.expenses.ExpenseFactory;
import com.splitwise.models.expenses.ExpenseType;
import com.splitwise.models.splits.Split;
import com.splitwise.models.splits.SplitFactory;

import java.util.ArrayList;
import java.util.List;

public class AddExpenseCommand implements Command {
    @Override
    public void execute(String[] cmd) throws InvalidExpenseTypeException, InvalidSplitTypeException,
            InvalidSplitsTotalException, NoSuchUserException {
        BookKeeper bk = BookKeeper.getInstance();
        // 1. expense type
        ExpenseType expType = null;
        try {
            expType = ExpenseType.fromString(cmd[1]);
        } catch (InvalidExpenseTypeException e) {
            System.out.println(e.getMessage());
            return;
        }

        // 2. name
        String name = cmd[2];

        // 3. total amount
        double totalAmount = Double.parseDouble(cmd[3]);

        // 4. created by
        User createdBy = null;
        try {
            createdBy = Utils.getUser(cmd[4]);
        } catch (NoSuchUserException e) {
            System.out.println(e.getMessage());
            return;
        }

        // now make expense...
        Expense expense = null;
        try {
            expense = ExpenseFactory.createExpense(expType, name, createdBy, totalAmount);
        } catch (InvalidExpenseTypeException | IllegalStateException ignore) {

        }

        // now add paid by and splits

        if (cmd.length > 5) {
            User paidBy = null;
            try {
                paidBy = Utils.getUser(cmd[4]);
            } catch (NoSuchUserException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            expense.setPaidBy(paidBy);

            int numberOfSplits = cmd.length - 6;
            if (numberOfSplits % 2 != 0) {
                System.out.println("Invalid input splits!!");
                return;
            }

            // now add splits
            List<Split> splits = new ArrayList<Split>();
            if (expType.equals(ExpenseType.EQUAL)) {
                for (int i = 0; i < numberOfSplits; i += 2) {
                    User user = null;
                    try {
                        user = Utils.getUser(cmd[6 + i]);
                    } catch (NoSuchUserException e) {
                        System.out.println("no such user!!");
                        return;
                    }

                    Split split = SplitFactory.createSplit(expType, user);
                    splits.add(split);
                }
            } else {
                for (int i = 0; i < numberOfSplits; i += 2) {
                    User user = null;
                    try {
                        user = Utils.getUser(cmd[6 + i]);
                    } catch (NoSuchUserException e) {
                        System.out.println("no such user!!");
                        return;
                    }
                    double amountOrPercent = Double.parseDouble(cmd[7 + i]);
                    Split split = SplitFactory.createSplit(expType, user, amountOrPercent);
                    splits.add(split);
                }
            }

            expense.setSplits(splits);
        }

        bk.addExpense(expense);
    }
}
