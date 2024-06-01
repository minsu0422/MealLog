package com.example.meallog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText nameInput = findViewById(R.id.nameInput);
        Button confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(v -> {
            Intent intent = new Intent(InputActivity.this, MainScreenActivity.class);
            intent.putExtra("name", nameInput.getText().toString());
            startActivity(intent);
        });
    }
}
