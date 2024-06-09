package com.example.meallog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // EditText inputs
        EditText nameInput = findViewById(R.id.nameInput);
        EditText ageInput = findViewById(R.id.ageInput);
        EditText heightInput = findViewById(R.id.heightInput);
        EditText weightInput = findViewById(R.id.weightInput);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        RadioButton femaleButton = findViewById(R.id.femaleButton);
        RadioButton maleButton = findViewById(R.id.maleButton);
        Button confirmButton = findViewById(R.id.confirmButton);

        // Setup confirmButton click listener
        confirmButton.setOnClickListener(v -> {
            // Retrieve input values
            String name = nameInput.getText().toString();
            int age = Integer.parseInt(ageInput.getText().toString());
            int height = Integer.parseInt(heightInput.getText().toString());
            int weight = Integer.parseInt(weightInput.getText().toString());

            // Get selected gender
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            String gender = "";
            if (selectedGenderId == R.id.femaleButton) {
                gender = "Female";
            } else if (selectedGenderId == R.id.maleButton) {
                gender = "Male";
            }

            // Save values to SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", name);
            editor.putInt("age", age);
            editor.putInt("height", height);
            editor.putInt("weight", weight);
            editor.putString("gender", gender);
            editor.apply();

            // Pass values to MainScreenActivity
            Intent intent = new Intent(InputActivity.this, MainScreenActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            intent.putExtra("height", height);
            intent.putExtra("weight", weight);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }
}