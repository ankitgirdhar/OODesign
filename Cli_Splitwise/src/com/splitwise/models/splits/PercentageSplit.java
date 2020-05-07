package com.splitwise.models.splits;

import com.splitwise.models.User;
import com.splitwise.models.expenses.ExpenseType;

public class PercentageSplit extends Split {
    private double percent;
    public PercentageSplit(User user, double percent) {
        super(user);
        setPercent(percent);
        setType(ExpenseType.PERCENT);
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
