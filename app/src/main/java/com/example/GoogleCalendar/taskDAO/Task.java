package com.example.GoogleCalendar.taskDAO;

public class Task {
    private String title;
    private String detail;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public Task(String title, String detail, int day, int month, int year, int hour, int minute) {
        this.title = title;
        this.detail = detail;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public Task() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getTime(){
        return this.hour+" "+this.minute;
    }

    public String getDate(){
        return this.day+"/"+this.month+"/"+this.year;
    }
}
