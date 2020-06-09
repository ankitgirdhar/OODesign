package com.splitwise;

import com.splitwise.exceptions.*;
import com.splitwise.models.User;
import com.splitwise.models.expenses.Expense;
import com.splitwise.models.expenses.ExpenseFactory;
import com.splitwise.models.expenses.ExpenseType;
import com.splitwise.models.splits.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookKeeper {
    private Map<Long, Expense> expenses;
    private Map<Long, User> users;
    private Map<String, User> userByEmail;
    private Map<User, Map<User,Double>> balances;
    private static BookKeeper INSTANCE;

    private BookKeeper() {
        expenses = new HashMap<>();
        users = new HashMap<>();
        balances = new HashMap<>();
        userByEmail = new HashMap<>();
    }

    public static BookKeeper getInstance() {
        if(INSTANCE == null)
            INSTANCE = new BookKeeper();
        return INSTANCE;
    }

    public void showAllBalances() {

        for (User user: balances.keySet())
            showBalance(user);
    }

    public void showBalance(User user) {
        Map<User, Double> userBalances = balances.get(user);
        boolean hadBalance = false;
        for(User user1 : userBalances.keySet()) {
            double amount = userBalances.get(user1);

            if(amount>0) {
                System.out.println(user.getName() + " owes " + amount + "to" + user1.getName());
                hadBalance = true;
            }
            else if(amount<0) {
                System.out.println(user.getName() + " gets " + (-amount) + " from " + user1.getName());
                hadBalance = true;
            }
        }
        if(!hadBalance)
            System.out.println(user.getName() + " has no dues!!");
    }

    public void showBalance(Long userId) throws NoSuchUserException {
        showBalance(getUser(userId));
    }

    public void addExpense(Expense e) throws InvalidExpenseTypeException, InvalidSplitTypeException, InvalidSplitsTotalException, NoSuchUserException {
        expenses.put(e.getUid(),e);
        for(Split s : e.getSplits()) {
            User paidTo = s.getUser();
            if(e.getPaidBy().equals(paidTo))
                continue;

            if(!balances.containsKey(e.getPaidBy()))
                throw new NoSuchUserException("please add the user before adding expense!");

            if(!balances.get(e.getPaidBy()).containsKey(paidTo))
                balances.get(e.getPaidBy()).put(paidTo, 0.0d);
            balances.get(e.getPaidBy()).put(paidTo, s.getAmount() + balances.get(e.getPaidBy()).get(paidTo));

            if(!balances.containsKey(paidTo))
                throw new NoSuchUserException("please add user before adding expenses");
            if(!balances.get(paidTo).containsKey(e.getPaidBy()))
                balances.get(paidTo).put(e.getPaidBy(), 0.0d);
            balances.get(paidTo).put( e.getPaidBy(), balances.get(paidTo).get(e.getPaidBy()) - s.getAmount());
        }

    }

    public List<Expense> getUserExpenses(User user) {
        List<Expense> userExpenses = new ArrayList();
        for(long expenseId : user.getExpenseIDs())
            userExpenses.add(expenses.get(expenseId));
        return userExpenses;
    }

    public List<Expense> getUserExpenses(Long userId) throws NoSuchUserException {
        return getUserExpenses(getUser(userId));
    }

    public void addUser(User user) {
        users.put(user.getUid(),user);
        if(user.getEmail()!= null || user.getEmail() != " ")
            userByEmail.put(user.getEmail(), user);
        balances.put(user,new HashMap());
        System.out.println("User added successfully!!");
    }

    public User getUser(Long uid) throws NoSuchUserException {
        if(!users.containsKey(uid))
            throw new NoSuchUserException("user with uid:" + uid + " doesn't exist!");
        return users.get(uid);
    }

    public User getUser(String email) throws NoSuchUserException {
        for (User u : users.values()) {
            if(u.getEmail().equals(email))
                return u;
        }
        throw new NoSuchUserException("user with" + email + "doesn't exist");

    }

    public void changeEmail(User user, String email) throws DuplicateUserFoundException {
        if(userByEmail.containsKey(email) && !userByEmail.get(email).equals(user))
            throw new DuplicateUserFoundException("email id already registered by another user!!");
        user.setEmail(email);
        userByEmail.put(email,user);
    }


    public Map<Long, Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Map<Long, Expense> expenses) {
        this.expenses = expenses;
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    public Map<String, User> getUserByEmail() {
        return userByEmail;
    }

    public void setUserByEmail(Map<String, User> userByEmail) {
        this.userByEmail = userByEmail;
    }

    public Map<User, Map<User, Double>> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Map<User, Double>> balances) {
        this.balances = balances;
    }
}
