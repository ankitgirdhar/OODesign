package com.calendar.models;

public abstract class Entry implements Comparable<Entry> {

    private Date date;
    private Time time;
    private String label;

    private boolean isRepeating;
    private int intervalOfRepetition;

    public Entry(Date date, Time time, String label) {
        this.date = date;
        this.time = time;
        this.label = label;
        isRepeating = false;
        intervalOfRepetition = 0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isRepeating() {
        return isRepeating;
    }

    public void setRepeating(boolean repeating) {
        isRepeating = repeating;
    }

    public int getIntervalOfRepetition() {
        return intervalOfRepetition;
    }

    public void setIntervalOfRepetition(int intervalOfRepetition) {
        this.intervalOfRepetition = intervalOfRepetition;
    }

    public int compareTo(Entry obj) {
        if(this.date.compareTo(obj.date))
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "date=" + this.date.toLong() +
                ", time=" + this.time.toAmPm() +
                ", label='" + this.label + '\'' +
                ", isRepeating=" + this.isRepeating +
                ", intervalOfRepetition=" + this.intervalOfRepetition +
                '}';
    }
}
