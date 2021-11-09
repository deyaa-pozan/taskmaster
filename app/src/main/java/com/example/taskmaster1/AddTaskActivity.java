package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.services.securitytoken.model.Tag;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.State;
import com.amplifyframework.datastore.generated.model.Task;
public class AddTaskActivity extends AppCompatActivity {
    private static final String TAG = "AddTask";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Button toastShow = findViewById(R.id.addNewTask);
        toastShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskTitle = findViewById(R.id.taskTitle);
                String title = taskTitle.getText().toString();

                EditText taskBody = findViewById(R.id.taskDescription);
                String body = taskBody.getText().toString();


//                Task task = new Task(title, body, State.NEW);
//                AppDatabase.getInstance(getApplicationContext()).taskDao().insert(task);
                dataStore(title, body, State.NEW);


                Toast punchToast = Toast.makeText(getApplicationContext(),"submitted!", Toast.LENGTH_SHORT);
                punchToast.show();
            }
        });
    }

    private void dataStore(String title, String body, State state) {
        Task task = Task.builder().title(title).state(state).body(body).build();

        // save with the datastore
        Amplify.DataStore.save(task, result -> {
            Log.i(TAG, "Task Saved");
        }, error -> {
            Log.i(TAG, "Task Not Saved");
        });

    }
}
