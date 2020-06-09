package com.splitwise.models.expenses;

import com.splitwise.exceptions.InvalidSplitTypeException;
import com.splitwise.models.User;
import com.splitwise.models.splits.ExactAmountSplit;
import com.splitwise.models.splits.Split;

import java.util.List;

public class ExactAmountExpense extends Expense {
    public ExactAmountExpense(String name, double totalAmount, User createdBy) {
        super(name, totalAmount, createdBy);
    }

    @Override
    void checkTypes() throws InvalidSplitTypeException {
        List<Split> splits = getSplits();
        for(Split s : splits) {
            if(!(s instanceof ExactAmountSplit))
                throw new InvalidSplitTypeException("split type should be of 'EXACT'!");
        }
    }

    @Override
    void calculateSplits() {
    }
}
