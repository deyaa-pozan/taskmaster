package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OneTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_task);
        Intent intent = getIntent();
        TextView text = findViewById(R.id.taskname);
        String taskName = intent.getExtras().getString("task","null");
        text.setText(taskName);
    }
}