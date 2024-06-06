package com.example.meallog;

import android.content.Intent;
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
            Intent intent = new Intent(InputActivity.this, MainScreenActivity.class);
            intent.putExtra("name", nameInput.getText().toString());
            intent.putExtra("age", ageInput.getText().toString());
            intent.putExtra("height", heightInput.getText().toString());
            intent.putExtra("weight", weightInput.getText().toString());

            // Get selected gender
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            String gender = "";
            if (selectedGenderId == R.id.femaleButton) {
                gender = "Female";
            } else if (selectedGenderId == R.id.maleButton) {
                gender = "Male";
            }
            intent.putExtra("gender", gender);

            startActivity(intent);
        });
    }
}

