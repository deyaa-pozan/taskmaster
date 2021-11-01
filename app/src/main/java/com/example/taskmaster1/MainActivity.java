package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTask = findViewById(R.id.button_first);
        Button allTasks = findViewById(R.id.button_first2);
        Button task1 = findViewById(R.id.task1);
        Button task2 = findViewById(R.id.task2);
        Button task3 = findViewById(R.id.task3);
        Button settings = findViewById(R.id.settings);

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

        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTaskOne = new Intent(MainActivity.this, OneTaskActivity.class);
                String task = task1.getText().toString();
                goToTaskOne.putExtra("task",task);
                startActivity(goToTaskOne);
            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTaskTwo = new Intent(MainActivity.this, OneTaskActivity.class);
                String task = task2.getText().toString();
                goToTaskTwo.putExtra("task",task);
                startActivity(goToTaskTwo);
            }
        });

        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = task3.getText().toString();
                Intent goToTaskThree = new Intent(MainActivity.this, OneTaskActivity.class);
                goToTaskThree.putExtra("task",task);
                startActivity(goToTaskThree);
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