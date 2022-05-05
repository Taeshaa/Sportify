package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button btn,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn= findViewById(R.id.button2);
        Drawable img = btn.getContext().getResources().getDrawable( R.drawable.Student );
        btn.setCompoundDrawablesWithIntrinsicBounds( img, null, null, null);

        btn.setOnClickListener(view -> {
            startActivity(new Intent(HomePage.this, StudentSign.class));
        });
        login.setOnClickListener(view -> {
            startActivity(new Intent(HomePage.this, StudentLogin.class));
        });
    }
}