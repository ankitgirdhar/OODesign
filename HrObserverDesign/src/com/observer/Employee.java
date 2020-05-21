package com.observer;

public class Employee implements Observer {

    private HrDepartment hrDepartment;

    private static int observerIdTracker = 0;

    private int observerId;

    public Employee(HrDepartment hrDepartment) {
        this.hrDepartment = hrDepartment;
        setObserverId(observerIdTracker++);
        System.out.println("New employee id: " + observerId + "added! Welcome !!");
        hrDepartment.register(this);
    }


    @Override
    public void update() {
        System.out.println("Message for employee:" + getObserverId());
        System.out.println(getHrDepartment().getOnBoardingMessage());
        System.out.println("Your joining date will be:");
        System.out.println(getHrDepartment().getJoiningDate());
    }

    public HrDepartment getHrDepartment() {
        return hrDepartment;
    }

    public int getObserverId() {
        return observerId;
    }

    public void setObserverId(int observerId) {
        this.observerId = observerId;
    }
}
