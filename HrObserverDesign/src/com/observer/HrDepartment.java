package com.observer;

import java.util.ArrayList;
import java.util.Date;

public class HrDepartment implements Subject {
    private ArrayList<Observer> observers;
    private String onBoardingMessage;
    private Date joiningDate;

    public HrDepartment() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        int observerIndex = observers.indexOf(observer);
        System.out.println( "Employee" + (observerIndex+1) + "removed from the employees list!!");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObservers() {
        for( Observer observer : observers) {
            observer.update();
        }
    }

    public String getOnBoardingMessage() {
        return onBoardingMessage;
    }

    public void setOnBoardingMessage(String onBoardingMessage) {
        this.onBoardingMessage = onBoardingMessage;
        notifyObservers();
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
        notifyObservers();
    }
}
