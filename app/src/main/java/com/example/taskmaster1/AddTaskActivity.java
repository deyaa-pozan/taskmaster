package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.amazonaws.services.securitytoken.model.Tag;
import com.amplifyframework.api.graphql.model.ModelMutation;
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



               RadioButton b1=findViewById(R.id.radioButton1);
                RadioButton b2=findViewById(R.id.radioButton2);
                RadioButton b3=findViewById(R.id.radioButton3);


                String id = null;
                if(b1.isChecked()){
                    id="1";
                }
                else if(b2.isChecked()){
                    id="2";
                }
                else if(b3.isChecked()){
                    id="3";
                }





                dataStore(title, body, State.NEW,id);



                System.out.println( ".....................>>>>>>>>>>>>>>>>" +  "Task ID is " + title + ".....................>>>>>>>>>>>>>>>>"


                );


                Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                startActivity(intent);

            }



        });



    }
    private void dataStore(String title, String body, com.amplifyframework.datastore.generated.model.State state, String id) {
        Task task = Task.builder().title(title).teamId(id).state(state).body(body).build();


        Amplify.API.mutate(ModelMutation.create(task),succuess-> {
            Log.i("Add Task", "Saved to DYNAMODB");
        }, error -> {
            Log.i("Add Task", "error saving to DYNAMODB");
        });

    }

}
