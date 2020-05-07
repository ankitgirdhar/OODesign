package com.splitwise.models.expenses;


import com.splitwise.Utils;
import com.splitwise.exceptions.InvalidSplitTypeException;
import com.splitwise.exceptions.InvalidSplitsTotalException;
import com.splitwise.imports.Image;
import com.splitwise.models.Auditable;
import com.splitwise.imports.Geolocation;
import com.splitwise.models.User;
import com.splitwise.models.splits.Split;

import java.util.List;

public abstract class Expense extends Auditable {
    private String name;
    private double totalAmount;
    private User paidBy;
    private User createdBy;
    private static ExpenseType type;
    private List<Split> splits;

    private String notes;
    private Geolocation geolocation;
    private List<Image> images;

    public Expense(String name, double totalAmount, User createdBy) {
        super();
        setName(name);
        setTotalAmount(totalAmount);
        setCreatedById(createdBy);
    }

    boolean validate() {
        double sum = 0;
        for( Split s : splits)
            sum += s.getAmount();
        return Utils.isApproxEqual(sum, getTotalAmount());
    }

    abstract void checkTypes() throws InvalidSplitTypeException;

    abstract void calculateSplits();

    public static ExpenseType getType() {
        return type;
    }

    public static void setType(ExpenseType type) {
        Expense.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedById(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) throws InvalidSplitsTotalException, InvalidSplitTypeException {
        this.splits = splits;
        checkTypes();
        calculateSplits();
        if(!validate())
            throw new InvalidSplitsTotalException("Splits total doesn't match total Expense amount!!");

    }

    public void addSplit(Split s) {
        splits.add(s);
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }
}
