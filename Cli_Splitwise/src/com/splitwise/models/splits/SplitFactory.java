package com.splitwise.models.splits;

import com.splitwise.exceptions.InvalidExpenseTypeException;
import com.splitwise.models.User;
import com.splitwise.models.expenses.ExpenseType;

import java.security.InvalidParameterException;

public class SplitFactory {
    public static Split createSplit(ExpenseType type, User user, double amountOrPercent) throws InvalidExpenseTypeException {
        switch (type) {
            case EXACT:
                return new ExactAmountSplit(user,amountOrPercent);
            case PERCENT:
                return new PercentageSplit(user,amountOrPercent);
            case EQUAL:
                return new EqualSplit(user);
            default:
                throw  new InvalidExpenseTypeException("split type is incorrect!!");
        }

    }

    public static Split createSplit(ExpenseType type, User user) throws InvalidExpenseTypeException {
        if(!type.equals(ExpenseType.EQUAL)) {
            throw new InvalidParameterException("please add the amount also!!");
        }
        return createSplit(type,user,0.0d);
    }
}
