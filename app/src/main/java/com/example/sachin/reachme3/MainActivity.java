package com.example.sachin.reachme3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button,track,search;
    String phoneNumber;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.phoneText);
        button = (Button)findViewById(R.id.phoneButton);
        track = (Button)findViewById(R.id.track);
        search = (Button)findViewById(R.id.search);
        shared = getSharedPreferences("ReachMe", Context.MODE_PRIVATE);
        if (shared.contains("userKey")){
            Log.d("paapu","Login:"+String.valueOf(shared.getBoolean("login",true)));
            editText.setText(String.valueOf(shared.getString("userKey","NoUser")));
            startActivity(new Intent(MainActivity.this,Register.class));
            finish();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber = editText.getText().toString();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(getString(R.string.firebase_path)+"/"+getString(R.string.userDetails));
                databaseReference.child(phoneNumber).child("phone").setValue(phoneNumber);
                final SharedPreferences.Editor editor = shared.edit();
                editor.putString("userKey",phoneNumber);
                editor.putBoolean("login",true);
                editor.commit();
            }
        });
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TrackerActivity.class);
                intent.putExtra("phone",phoneNumber);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("phone",phoneNumber);
                startActivity(intent);
            }
        });
    }
}
