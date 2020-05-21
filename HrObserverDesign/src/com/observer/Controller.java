package com.observer;


import java.util.Date;

public class Controller {
    public static void main(String[] args) {
        HrDepartment hrDepartment = new HrDepartment();
        hrDepartment.register(new Employee(hrDepartment));
        hrDepartment.register(new Employee(hrDepartment));
        hrDepartment.register(new Employee(hrDepartment));

        hrDepartment.setOnBoardingMessage("Hi! This is your onboarding email! Welcome to the company");
        hrDepartment.setJoiningDate(new Date());
    }
}
