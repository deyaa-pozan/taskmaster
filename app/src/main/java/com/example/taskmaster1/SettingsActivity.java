package com.example.taskmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RadioButton;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        findViewById(R.id.save).setOnClickListener(view -> {
            TextView text = findViewById(R.id.username_text);
            String name =text.getText().toString();
            RadioButton b1=findViewById(R.id.radioButtonSet1);
            RadioButton b2=findViewById(R.id.radioButtonSet2);
            RadioButton b3=findViewById(R.id.radioButtonSet3);


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



            editor.putString("Team",id);
            editor.putString("username",name);
            editor.apply();
        });


    }
}