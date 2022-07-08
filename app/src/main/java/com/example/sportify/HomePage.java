package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button btn, sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn= findViewById(R.id.button2);
        sign=findViewById(R.id.buttonn);




        btn.setOnClickListener(view -> {
            startActivity(new Intent(HomePage.this, StudentLogin.class));
        });
        sign.setOnClickListener(view -> {
            startActivity(new Intent(HomePage.this, StudentSign.class));
        });
    }
}