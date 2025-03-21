package com.example.cellular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<String> {

     Context context;
     ArrayList<String> tasks;

    public TaskAdapter(Context context, ArrayList<String> tasks) {
        super(context, R.layout.task_item, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Создаем View для элемента списка
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.task_item, parent, false);
        // Находим TextView и устанавливаем текст
        TextView taskText = rowView.findViewById(R.id.taskText);
        taskText.setText(tasks.get(position));

        return rowView;
    }
}
