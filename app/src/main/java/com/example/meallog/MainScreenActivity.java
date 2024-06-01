package com.example.meallog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainScreenActivity extends AppCompatActivity {
    protected void to_create(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        TextView welcomeText = findViewById(R.id.welcomeText);
        String name = getIntent().getStringExtra("name");
        welcomeText.setText("환영합니다, " + name + "님!");
    }
}

