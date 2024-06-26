package com.example.GoogleCalendar.taskDAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "calendarApp.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "taskManager";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "detail TEXT, " +
                "day INTEGER, " +
                "month INTEGER, " +
                "year INTEGER, " +
                "hour INTEGER, " +
                "minute INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    @SuppressLint("Range")
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tasks", null);

        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                task.setDetail(cursor.getString(cursor.getColumnIndex("detail")));
                task.setDay(cursor.getInt(cursor.getColumnIndex("day")));
                task.setMonth(cursor.getInt(cursor.getColumnIndex("month")));
                task.setYear(cursor.getInt(cursor.getColumnIndex("year")));
                task.setHour(cursor.getInt(cursor.getColumnIndex("hour")));
                task.setMinute(cursor.getInt(cursor.getColumnIndex("minute")));

                taskList.add(task);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return taskList;
    }
}

