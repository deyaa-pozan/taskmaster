package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTask = findViewById(R.id.button_first);
        Button allTasks = findViewById(R.id.button_first2);
        Button settings = findViewById(R.id.settings);
        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras felis massa, elementum a nibh sed, sodales posuere nunc. Vivamus eget ante malesuada, fermentum tellus eget, dignissim enim. Duis felis enim, facilisis in tortor eget, pellentesque tristique dolor. Nullam hendrerit ex at sagittis tincidunt. Cras in sodales mauris. Quisque lobortis nisl quis rhoncus accumsan. ";
        RecyclerView recyclerView = findViewById(R.id.RV_main);
//        List tasks = new ArrayList<>();
//        Task task1 = new Task("Clean room", body, State.NEW );
//        Task task2 = new Task("Study", body, State.NEW );
//        Task task3 = new Task("Eat", body, State.NEW );
//        Task task4 = new Task("Coding", body, State.NEW );
//        Task task5 = new Task("Eat", body, State.NEW );
//        Task task6 = new Task("Sleep", body, State.NEW );
//        tasks.add(task1);
//        tasks.add(task2);
//        tasks.add(task3);
//        tasks.add(task4);
//        tasks.add(task5);
//        tasks.add(task6);
        List<Task> taskData = AppDatabase.getInstance(this).taskDao().getAll();
        TaskAdapter taskAdapter = new TaskAdapter(taskData, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.canScrollVertically();
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(taskAdapter);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddTask = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(goToAddTask);
            }
        });

        allTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAllTasks = new Intent(MainActivity.this, AllTasksActivity.class);
                startActivity(goToAllTasks);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String instName = sharedPreferences.getString("username","Go to settings and set the username");
        TextView welcome = findViewById(R.id.username);
        welcome.setText(instName);
    }
}