package com.observer;

public interface Subject {
    void register(Observer observer);
    void unRegister(Observer observer);
    public void notifyObservers();
}
