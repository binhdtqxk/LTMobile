package com.example.GoogleCalendar.taskDAO;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.GoogleCalendar.R;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private ListView listView;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        listView = findViewById(R.id.listViewTasks);
        dbHelper = new DatabaseHelper(this);

        loadTasksFromDatabase();
    }

    private void loadTasksFromDatabase() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("taskManager", null, null, null, null, null, null);

        List<Task> tasks = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                @SuppressLint("Range") String detail = cursor.getString(cursor.getColumnIndex("detail"));
                @SuppressLint("Range") int day = cursor.getInt(cursor.getColumnIndex("day"));
                @SuppressLint("Range") int month = cursor.getInt(cursor.getColumnIndex("month"));
                @SuppressLint("Range") int year = cursor.getInt(cursor.getColumnIndex("year"));
                @SuppressLint("Range") int hour = cursor.getInt(cursor.getColumnIndex("hour"));
                @SuppressLint("Range") int minute = cursor.getInt(cursor.getColumnIndex("minute"));

                tasks.add(new Task(title, detail, day, month, year, hour, minute));
            } while (cursor.moveToNext());
        }
        cursor.close();

        taskAdapter = new TaskAdapter(this, tasks);
        listView.setAdapter(taskAdapter);
    }
}
