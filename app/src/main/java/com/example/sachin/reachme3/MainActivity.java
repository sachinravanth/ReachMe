package com.example.sachin.reachme3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button,track,search;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.phoneText);
        button = (Button)findViewById(R.id.phoneButton);
        track = (Button)findViewById(R.id.track);
        search = (Button)findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                phoneNumber = editText.getText().toString();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(getString(R.string.firebase_path)+"/"+getString(R.string.userDetails));
                databaseReference.child(phoneNumber).child("phone").setValue(phoneNumber);*/
                startActivity(new Intent(MainActivity.this,PhoneActivity.class));
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
