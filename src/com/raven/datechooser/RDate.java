package com.raven.datechooser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class RDate {
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public RDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public RDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        init(calendar);
    }

    public RDate(Calendar calendar) {
        init(calendar);
    }

    public RDate() {
        init(Calendar.getInstance());
    }

    public void init(Calendar calendar) {
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DATE);
    }

    private int year;
    private int month;
    private int day;

    public int compareTo(RDate date) {
        return toDate().compareTo(date.toDate());
    }

    @Override
    public String toString() {
        return day + "" + month + "" + year;
    }

    public boolean equals(RDate date) {
        return year == date.getYear() && month == date.getMonth() && day == date.getDay();
    }

    public boolean isBetweenOf(RDate from, RDate to) {
        Date date = toDate();
        return date.after(from.toDate()) && date.before(to.toDate());
    }

    public Date toDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String st = year + "-" + month + "-" + day;
        try {
            return df.parse(st);
        } catch (ParseException e) {
            throw new RuntimeException("Date format error");
        }
    }

    public RDate copy() {
        return new RDate(year, month, day);
    }
}
