package com.example.GoogleCalendar.taskDAO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.GoogleCalendar.R;

import java.util.List;

public class TaskAdapter extends BaseAdapter {

    private Context context;
    private List<Task> taskList;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false);
        }

        Task task = taskList.get(position);

        TextView title = convertView.findViewById(R.id.taskTitle);
        TextView detail = convertView.findViewById(R.id.taskDetail);
        TextView date = convertView.findViewById(R.id.taskDate);
        TextView hour = convertView.findViewById(R.id.taskHour);

        title.setText(task.getTitle());
        detail.setText(task.getDetail());
        date.setText(task.getDate());
        hour.setText(task.getTime());

        return convertView;
    }
}