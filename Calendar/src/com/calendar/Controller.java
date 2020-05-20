package com.calendar;

import com.calendar.exceptions.InvalidDateException;
import com.calendar.exceptions.InvalidTimeException;
import com.calendar.exceptions.NoEntryFoundException;
import com.calendar.models.*;

public class Controller {
    public static void main(String[] args) throws InvalidDateException, InvalidTimeException, NoEntryFoundException {
        Calendar calendar = new Calendar();
        Date date1 = new Date(2019,10,20);
        Time time1 = new Time(10,20);
        Date date2 = new Date(2019,10,19);
        Time time2 = new Time(9,20);

        Reminder reminder1 = new Reminder(date2,time2,"Reminder 1","Do not forget the meeting tomorrow.");
        reminder1.setIntervalOfRepetition(5);
        reminder1.setRepeating(true);


        Event event1 = new Event(date1, time1, "Dentist appointment", reminder1);
        event1.setReminder(reminder1);
        event1.setRepeating(true);
        event1.setIntervalOfRepetition(3);
        calendar.addEntry(event1);

        Event event2 = new Event(date2, time2, "Doctors appointement", reminder1);
        event2.setReminder(reminder1);
        event2.setIntervalOfRepetition(3);
        calendar.addEntry(event2);

        Meeting meeting1 = new Meeting(date1, time1, "Meeting with PM", reminder1);
        meeting1.addPerson("nina@ztm.si");
        meeting1.addPerson("janez@ztm.si");
        meeting1.setInvites();
        calendar.addEntry(meeting1);


        calendar.listAllEntries();
        calendar.listAllMeetings();
        System.out.println(calendar.returnSoonestEntry());

    }
}
