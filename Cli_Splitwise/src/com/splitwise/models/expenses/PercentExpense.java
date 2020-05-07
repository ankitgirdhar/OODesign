package com.splitwise.models.expenses;

import com.splitwise.Utils;
import com.splitwise.exceptions.InvalidSplitTypeException;
import com.splitwise.models.User;
import com.splitwise.models.splits.ExactAmountSplit;
import com.splitwise.models.splits.PercentageSplit;
import com.splitwise.models.splits.Split;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(String name, double totalAmount, User createdBy) {
        super(name, totalAmount, createdBy);
    }

    @Override
    void checkTypes() throws InvalidSplitTypeException {
        List<Split> splits = getSplits();
        for(Split s : splits) {
            if(!(s instanceof PercentageSplit))
                throw new InvalidSplitTypeException("split type should be of 'PERCENT'!");
        }
    }

    @Override
    void calculateSplits() {
        double amount=0;
        List<Split> splits = getSplits();
        for(Split s : splits) {
            PercentageSplit ps = (PercentageSplit) s;
            amount = Utils.roundOff(getTotalAmount() * ps.getPercent() / 100.0d);
            s.setAmount(amount);
        }
    }
}
