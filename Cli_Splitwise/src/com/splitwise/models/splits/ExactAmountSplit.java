package com.splitwise.models.splits;

import com.splitwise.models.User;
import com.splitwise.models.expenses.ExpenseType;

public class ExactAmountSplit extends Split {
    public ExactAmountSplit(User user, double amount) {
        super(user);
        setType(ExpenseType.EXACT);
        setAmount(amount);
    }
}
