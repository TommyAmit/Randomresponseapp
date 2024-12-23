package com.example.randomresponseapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private int colorIndex = 0; // Tracks the current color
    private final int[] colors = {Color.BLACK, Color.RED, Color.BLUE}; // Color options

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputField = findViewById(R.id.inputField);
        resultText = findViewById(R.id.resultText);
        Button showTextButton = findViewById(R.id.showTextButton);
        Button changeColorButton = findViewById(R.id.changeColorButton);

        // Predefined responses
        String[] responses = {
                "Great choice!", "Interesting!", "Try again?", "Nice one!",
                "Not bad!", "Keep it up!", "That's cool!", "Why not?",
                "Amazing!", "Good luck!"
        };

        // Show me the text button logic
        showTextButton.setOnClickListener(v -> {
            String userInput = inputField.getText().toString();
            if (!userInput.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(responses.length);
                String randomResponse = responses[randomIndex];
                resultText.setText(randomResponse + " " + userInput);
            }
        });

        // Change color button logic
        changeColorButton.setOnClickListener(v -> {
            colorIndex = (colorIndex + 1) % colors.length; // Cycle through colors
            resultText.setTextColor(colors[colorIndex]);
        });
    }
}