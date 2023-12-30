package com.example.bmicalculatorr;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button btnCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightStr)) {
            textViewResult.setText("Please enter weight and height");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // Convert height to meters

        float bmi = weight / (height * height);

        displayResult(bmi);
    }

    private void displayResult(float bmi) {
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 24.9) {
            category = "Normal weight";
        } else if (bmi < 29.9) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        String result = "BMI: " + String.format("%.2f", bmi) + "\nCategory: " + category;
        textViewResult.setText(result);
    }
}
