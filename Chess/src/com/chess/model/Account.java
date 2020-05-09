package com.chess.model;

public abstract class Account extends Auditable {
    private String userName;
    private String email;
    private String saltedHashPassword;

    public Account(String userName, String email, String saltedHashPassword) {
        this.userName = userName;
        this.email = email;
        this.saltedHashPassword = saltedHashPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSaltedHashPassword() {
        return saltedHashPassword;
    }

    public void setSaltedHashPassword(String saltedHashPassword) {
        this.saltedHashPassword = saltedHashPassword;
    }
}
