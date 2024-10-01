package com.example.fixitfitness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Helper method to check if a string contains only alphabetic characters
    private boolean isAlpha(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        // Iterates through each character to check if it's a letter
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false; // Returns false if any character is not a letter
            }
        }
        return true; // Returns true if all characters are alphabetic
    }
    public void handleSubmit(View view) {
        // Logs that the button has been clicked for debugging purposes
        // Create an Intent to start the ThirdActivity
        Log.d("2nd Activity", "The button is clicked");


        // Retrieves the user input from each EditText field

        EditText nameEdit = findViewById(R.id.Name); //name edit
        EditText ageEdit = findViewById(R.id.Age); //age edit
        EditText weightEdit = findViewById(R.id.Weight); // weight edit
        EditText heightEdit = findViewById(R.id.Height); //height edit

        // Convert user input to string
        String name = nameEdit.getText().toString();
        String age = ageEdit.getText().toString();
        String weight = weightEdit.getText().toString();
        String height = heightEdit.getText().toString();
        boolean validated = true; // Tracks if the input is valid


        // Validate the name input
        // Shows error message if valid

        if (isAlpha(name) == false || name.length() <= 0) {
            validated=false;
            showPopup(this, "Please enter a name");
            return;
        }

        // Validate the name length
        if (name.length() >= 20) {
            validated=false;
            showPopup(this, "Name is too long");
            return;
        }
        // Validate the age input
        if (age.length() <= 0) {
            validated=false;
            showPopup(this, "Please enter an age");
            return;
        }
        int ageInt;
        try {
            ageInt = Integer.parseInt(age);
            // Converts age to an integer
            // Age validation checks
            if (ageInt <= 0) {
                validated=false;
                showPopup(this, "Please enter a valid age");
                return;
            }
            if (ageInt <= 14) {
                validated=false;
                showPopup(this, "You are too young to use this app");
                return;
            }
            if (ageInt > 60) {
                validated=false;
                showPopup(this, "You are too old to use this app");
                return;
            }
        } catch (NumberFormatException e) {
            // Makes sure that the age is a number
            showPopup(this, "Please enter a valid age");
            return;
        }
        // Validates weight
        if (weight.length() <= 0) { // Checks that the user hasn't entered a weight
            validated=false;
            showPopup(this, "Please enter a weight");
            return;
        }
        int weightInt;
        try {
            // Converts the weight to an integer
            weightInt = Integer.parseInt(weight);
            if (weightInt <= 0) {
                validated=false;
                // Checks that the weight is not negative
                showPopup(this, "Please enter a valid weight");
                return;
            }
        } catch (NumberFormatException e) {
            // Makes sure that the weight is a number
            validated=false;
            showPopup(this, "Please enter a valid weight");
            return;
        }
        // Validates height
        if (height.length() <= 0) {
            // Checks that the user hasn't entered a height
            validated=false;
            showPopup(this, "Please enter a height");
            return;
        }
        int heightInt;
        try {
            // Converts the height to an integer
            heightInt = Integer.parseInt(height);
            if (heightInt < 0) {
                // Checks that the height is not negative
                validated=false;
                showPopup(this, "Please enter a valid height");
                return;
            }
            if (heightInt == 0) {
                throw new NumberFormatException();
            }

        if (heightInt > 220) {
            validated=false;
            showPopup(this, "You are too tall to use this app");
            return;
        }
        if (heightInt < 120) {
            validated=false;
            showPopup(this, "You are too short to use this app");
            return;
            }

        } catch (NumberFormatException e) {
            // Makes sure that the height is a number
            validated=false;
            showPopup(this, "Please enter a valid height");
            return;
        }

        // Creates an Intent to navigate to ThirdActivity with the user inputs
        Intent intent = new Intent(this, ThirdActivity.class);

        // Adds the validated input data to the intent
        intent.putExtra("name", name);
        intent.putExtra("age", ageInt);
        intent.putExtra("weight", weightInt);
        intent.putExtra("height", heightInt);

        startActivity(intent);
    }
    // Method to display a popup message to the user
    public static void showPopup(Context context, String errorMessage) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
    }
}