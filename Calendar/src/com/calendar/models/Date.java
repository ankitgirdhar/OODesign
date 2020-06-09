package com.calendar.models;
import com.calendar.exceptions.InvalidDateException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date() {
        Calendar currentDate = Calendar.getInstance();
        java.util.Date x = currentDate.getTime();
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        this.year = Integer.parseInt(formatYear.format(x));
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
        this.month = Integer.parseInt(formatMonth.format(x));
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");
        this.day = Integer.parseInt(formatDay.format(x));
    }


    public Date(int year,int month,int day) throws InvalidDateException {
        if(!isValid(year,month,day))
            throw new InvalidDateException("Please enter correct year/month/day!");
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean isValid(int year,int month,int day) {
        if(year < 0)
            return false;

        if((month < 1) || (month > 12))
            return false;

        if((day < 1) || (day > 31))
            return false;

        switch (month) {
            case 2 :
                return (isLeap(year) ? day <= 29 : day <= 28);
            case 4:
            case 6:
            case 9:
            case 11:
                return day < 31;
            default:
                return true;
        }
    }

    public static boolean isLeap(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean compareTo(Date d) {
        int day1 = d.getDay();
        int month1 = d.getMonth();
        int year1 = d.getYear();
        return (this.year <= year1) && (this.month <= month1) && (this.day <= day1);
    }

    public String toShort() {
        StringBuilder s = new StringBuilder();
        s.append(String.valueOf(this.year));
        s.append("-");
        if (this.month < 10) s.append("0");
        s.append(String.valueOf(this.month));
        s.append("-");
        if (this.day < 10) s.append("0");
        s.append(String.valueOf(this.day));
        return String.valueOf(s);
    }

    public String toLong() {
        StringBuilder s = new StringBuilder();
        switch (this.month) {
            case 1:
                s.append("January ");
                break;
            case 2:
                s.append("February ");
                break;
            case 3:
                s.append("March ");
                break;
            case 4:
                s.append("April ");
                break;
            case 5:
                s.append("May ");
                break;
            case 6:
                s.append("June ");
                break;
            case 7:
                s.append("July ");
                break;
            case 8:
                s.append("August ");
                break;
            case 9:
                s.append("September ");
                break;
            case 10:
                s.append("October ");
                break;
            case 11:
                s.append("November ");
                break;
            case 12:
                s.append("December ");
                break;
            default:
                s.append("");
        }


        s.append(String.valueOf(this.day));
        switch (this.day) {
            case 1:
                s.append("st, ");
                break;
            case 2:
                s.append("nd, ");
                break;
            case 3:
                s.append("rd, ");
                break;
            default:
                s.append("th, ");
                break;
        }
        s.append(String.valueOf(this.year));
        return String.valueOf(s);

    }



}
