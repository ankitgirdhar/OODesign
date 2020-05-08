package com.parking.models;

import com.parking.models.accounts.Account;

public class Person extends Auditable{
    private String name;
    private String address;
    private String phoneNumber;
    private Account account;

    public Person(String name, Account account) {
        setName(name);
        setAccount(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public static final class Builder {
        private String name;
        private String address;
        private String phoneNumber;
        private Account account;

        private Builder() {
        }


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder account(Account account) {
            this.account = account;
            return this;
        }

        public Person build() {
            Person person = new Person(name, account);
            person.setAddress(address);
            person.setPhoneNumber(phoneNumber);
            return person;
        }
    }
}
