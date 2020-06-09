package com.calendar.models;

import java.util.ArrayList;

public class Meeting extends Event{

    private ArrayList<String> attendees = new ArrayList<String>();

    public Meeting(Date date, Time time, String label, Reminder reminder) {
        super(date, time, label, reminder);
    }

    public ArrayList<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<String> attendees) {
        this.attendees = attendees;
    }

    public void addPerson(String person) {
        attendees.add(person);
    }

    public void removePerson(String person) {
        for(String obj : attendees) {
            if(obj.equals(person))
                attendees.remove(person);
        }
    }

    public void setInvites() {
        StringBuilder sb = new StringBuilder();

        for(String obj : attendees)
            sb.append(obj + ", ");

        System.out.println("Inviting to this meeting:" + sb);
    }
}
