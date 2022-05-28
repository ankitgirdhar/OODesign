package com.splitwise.models.expenses;

import com.splitwise.Utils;
import com.splitwise.exceptions.InvalidSplitTypeException;
import com.splitwise.models.User;
import com.splitwise.models.splits.EqualSplit;
import com.splitwise.models.splits.ExactAmountSplit;
import com.splitwise.models.splits.Split;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(String name, double totalAmount, User createdBy) {
        super(name, totalAmount, createdBy);
        setType(ExpenseType.EQUAL);
    }

    @Override
    public void checkTypes() throws InvalidSplitTypeException {
        List<Split> splits = getSplits();
        for(Split s : splits) {
            if (!(s instanceof EqualSplit))
                throw new InvalidSplitTypeException("split type should be 'EXACT'");
        }
    }

    @Override
    public void calculateSplits() {
        double amount=0;
        List<Split> splits = getSplits();
        for(Split s : splits) {
            amount = Utils.roundOff(getTotalAmount() / getSplits().size());
            s.setAmount(amount);
        }
    }


}
