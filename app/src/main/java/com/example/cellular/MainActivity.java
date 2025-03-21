package com.example.cellular;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     ListView taskListView;
     EditText taskInput;
     Button addTaskButton;
     ArrayList<String> tasks;
     TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация компонентов
        taskListView = findViewById(R.id.taskListView);
        taskInput = findViewById(R.id.taskInput);
        addTaskButton = findViewById(R.id.addTaskButton);
        // Инициализация списка задач
        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, tasks);
        taskListView.setAdapter(taskAdapter);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем введенную задачу
                String task = taskInput.getText().toString();
                if (!task.isEmpty()) {
                    // Добавляем задачу в список если она не пустая
                    tasks.add(task);
                    taskAdapter.notifyDataSetChanged();
                    taskInput.setText("");
                    // Отправляем задачу в сервис
                    Intent serviceIntent = new Intent(MainActivity.this, TaskTrackerService.class);
                    serviceIntent.putExtra("task", task);
                    startService(serviceIntent);
                }
            }
        });
    }
}