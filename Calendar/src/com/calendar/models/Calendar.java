package com.calendar.models;

import com.calendar.exceptions.NoEntryFoundException;


import java.util.TreeSet;

public class Calendar {

    private Date date;
    private String emailAddress;
    private TreeSet<Entry> entrySet;

    public Calendar() {
        date = new Date();
        entrySet = new TreeSet<>();
    }

    public Calendar(String emailAddress) {
        date = new Date();
        this.emailAddress = emailAddress;
        entrySet = new TreeSet<>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public TreeSet<Entry> getSet() {
        return entrySet;
    }

    public void setSet(TreeSet<Entry> set) {
        this.entrySet = set;
    }

    public void addEntry(Entry entry) {
        entrySet.add(entry);
    }

    public void removeEntry(Entry entry) {

        for(Entry e : entrySet) {
            if(e.equals(entry))
                entrySet.remove(e);
        }
    }

    public void listAllEntries() {
        System.out.println("All the events are:");
        for (Entry e : entrySet) {
            System.out.println(e.getLabel() + "on" + e.getDate().toLong() + " at " + e.getTime().toAmPm());
        }
    }

    public void listAllMeetings() {
        System.out.println("All the meetings are:");
        for( Entry e : entrySet) {
            if(e instanceof Meeting)
                System.out.println(e.getLabel() + " on " + e.getDate().toLong() + " at " + e.getTime().toAmPm());
        }
    }

    public Entry returnSoonestEntry() throws NoEntryFoundException {
        if(entrySet.size()==0)
            throw new NoEntryFoundException("No entry found!! Add some entries first!");
        return entrySet.first();
    }



}
