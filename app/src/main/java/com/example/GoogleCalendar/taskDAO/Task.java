package com.example.GoogleCalendar.taskDAO;

public class Task {
    private String title;
    private String detail;
    private LocalDateTime dateTime;

    private int repeatOption;

    public Task(String title, String detail, LocalDateTime dateTime , int repeatOption) {
        this.title = title;
        this.detail = detail;
        this.dateTime = dateTime;
        this.repeatOption = repeatOption;
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

    public int getRepeatOption() {
        return repeatOption;
    }

    public void setRepeatOption(int repeatOption) {
        this.repeatOption = repeatOption;
    }
}
