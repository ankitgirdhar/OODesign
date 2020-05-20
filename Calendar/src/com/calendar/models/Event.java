package com.calendar.models;

public class Event extends Entry {

    Reminder reminder;
    public Event(Date date, Time time, String label, Reminder reminder) {
        super(date, time, label);
        this.reminder = reminder;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
}
