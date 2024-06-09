package com.example.meallog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start Button 설정
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputActivity.class);
            startActivity(intent);
        });

        // 데이터베이스 초기화 및 데이터 삽입 코드를 백그라운드 스레드에서 실행
        new Thread(() -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
            databaseHelper.readAndStoreCSV(MainActivity.this);
        }).start();
    }
}
