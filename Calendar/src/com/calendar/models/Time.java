package com.calendar.models;
import com.calendar.exceptions.InvalidTimeException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {

    private int minute;
    private int hour;

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public Time() {
        Calendar currentDate = Calendar.getInstance();
        java.util.Date x = currentDate.getTime();
        SimpleDateFormat formathour= new SimpleDateFormat("HH");
        this.hour = Integer.parseInt(formathour.format(x));
        SimpleDateFormat formatminute = new SimpleDateFormat("mm");
        this.minute = Integer.parseInt(formatminute.format(x));
    }

    public Time(int hour, int minute) throws InvalidTimeException {
        if (!isValid(hour, minute)) throw new InvalidTimeException("Enter correct hour/minute!!");
        this.hour = hour;
        this.minute = minute;
    }

    public static boolean isValid(int hour, int minute) {
        Boolean valid = true;
        if ((hour < 0) || (hour > 24)) {valid=false;};
        if ((minute < 0) || (minute > 60)) {valid=false;};
        if ((hour==24) && ( minute > 0)) {valid=false;};
        return valid;
    }

    public String toAmPm() {
        StringBuilder s = new StringBuilder();

        if (this.hour < 12){
            s.append(this.hour);
            s.append(":");
            s.append(this.minute);
            s.append(" AM");
        }else{
            s.append(this.hour-12);
            s.append(":");
            s.append(this.minute);
            s.append(" PM");
        }
        return String.valueOf(s);
    }
}
