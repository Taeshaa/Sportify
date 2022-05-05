package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class StudentHome extends AppCompatActivity {
    Button racquet, ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        racquet=findViewById(R.id.racq);
        ball=findViewById(R.id.ball);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
    }
}