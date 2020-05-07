package com.splitwise.models.splits;

import com.splitwise.models.Auditable;
import com.splitwise.models.User;
import com.splitwise.models.expenses.ExpenseType;

public abstract class Split extends Auditable {
    private User user;
    private double amount;
    private String note;
    private static ExpenseType type;

    public Split(User user) {
        super();
        setUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static ExpenseType getType() {
        return type;
    }

    public static void setType(ExpenseType type) {
        Split.type = type;
    }
}
