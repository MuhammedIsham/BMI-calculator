package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weightInput = findViewById(R.id.weight_input);
        EditText heightInput = findViewById(R.id.height_input);
        Button calculateButton = findViewById(R.id.calculate_button);
        TextView resultText = findViewById(R.id.result_text);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (weightStr.isEmpty() || heightStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
                } else {
                    double weight = Double.parseDouble(weightStr);
                    double height = Double.parseDouble(heightStr);

                    if (height <= 0 || weight <= 0) {
                        Toast.makeText(MainActivity.this, "Invalid height or weight", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double bmi = weight / (height * height);
                    String interpretation;

                    if (bmi < 18.5) {
                        interpretation = "Underweight";
                    } else if (bmi >= 18.5 && bmi < 24.9) {
                        interpretation = "Normal weight";
                    } else if (bmi >= 25 && bmi < 29.9) {
                        interpretation = "Overweight";
                    } else {
                        interpretation = "Obesity";
                    }

                    String result = String.format("Your BMI: %.2f\nCategory: %s", bmi, interpretation);
                    resultText.setText(result);
                    resultText.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}