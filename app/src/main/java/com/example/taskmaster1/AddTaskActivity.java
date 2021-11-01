package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Button toastShow = findViewById(R.id.addNewTask);
        toastShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast punchToast = Toast.makeText(getApplicationContext(),"submitted!", Toast.LENGTH_SHORT);
                punchToast.show();
            }
        });
    }
}
