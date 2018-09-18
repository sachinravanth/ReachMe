package com.example.sachin.reachme3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    TextView display;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPreferences = getSharedPreferences("ReachMe", Context.MODE_PRIVATE);
        display=(TextView)findViewById(R.id.display);
        if (sharedPreferences.contains("userKey")){
            display.setText(String.valueOf(sharedPreferences.getString("userKey","Default")));
        }else {
            display.setText("Not registered...");
        }
    }
}
