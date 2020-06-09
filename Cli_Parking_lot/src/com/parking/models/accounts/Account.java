package com.parking.models.accounts;

import com.parking.models.Auditable;
import com.parking.models.Person;

public class Account extends Auditable {
    private String username;
    private String saltedHashPassword;
    private final Person person;
    private AccountStatus accountStatus;

    public Account(String username, String saltedHashPassword, Person person) {
        this.username = username;
        this.saltedHashPassword = saltedHashPassword;
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSaltedHashPassword() {
        return saltedHashPassword;
    }

    public void setSaltedHashPassword(String saltedHashPassword) {
        this.saltedHashPassword = saltedHashPassword;
    }

    public Person getPerson() {
        return person;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
