package com.splitwise.models.expenses;

import com.splitwise.exceptions.InvalidExpenseTypeException;
import com.splitwise.models.User;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseType type , String name , User createdBy, double totalAmount) throws InvalidExpenseTypeException {

        switch (type) {
            case EQUAL:
                return new EqualExpense(name, totalAmount, createdBy);
            case PERCENT:
                return new PercentExpense(name, totalAmount, createdBy);
            case EXACT:
                return new ExactAmountExpense(name,totalAmount,createdBy);
            default:
                throw new InvalidExpenseTypeException("Invalid Expense Type!!");
        }
    }
}
