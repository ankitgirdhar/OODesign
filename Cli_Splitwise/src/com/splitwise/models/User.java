package com.splitwise.models;

import java.util.List;
import java.util.Objects;

public class User extends Auditable{
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String hashedPass;
    private long uid;


    private List<Long> expenseIDs;

    public User(String name, String email, String hashedPass) {
        super();
        setName(name);
        setEmail(email);
        setHashedPass(hashedPass);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHashedPass() {
        return hashedPass;
    }

    public void setHashedPass(String hashedPass) {
        this.hashedPass = hashedPass;
    }

    @Override
    public long getUid() {
        return uid;
    }

    @Override
    public void setUid(long uid) {
        this.uid = uid;
    }

    public List<Long> getExpenseIDs() {
        return expenseIDs;
    }

    public void setExpenseIDs(List<Long> expenseIDs) {
        this.expenseIDs = expenseIDs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid() == user.getUid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", uid=" + uid +
                '}';
    }
}
