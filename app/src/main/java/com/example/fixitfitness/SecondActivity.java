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
    private boolean isAlpha(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public void handleSubmit(View view) {
        // Create an Intent to start the ThirdActivity
        Log.d("2nd Activity", "The button is clicked");


        //need to get user edits from each of the text fields

        EditText nameEdit = findViewById(R.id.Name); //name edit
        EditText ageEdit = findViewById(R.id.Age); //age edit
        EditText weightEdit = findViewById(R.id.Weight); // weight edit
        EditText heightEdit = findViewById(R.id.Height); //height edit

        String name = nameEdit.getText().toString();
        String age = ageEdit.getText().toString();
        String weight = weightEdit.getText().toString();
        String height = heightEdit.getText().toString();
        boolean validated = true;
        //validate the inputs
        // show error messages if applicable
        if (isAlpha(name) == false || name.length() <= 0) {
            validated=false;
            showPopup(this, "Please enter a name");
            return;
        }

        if (name.length() >= 20) {
            validated=false;
            showPopup(this, "Name is too long");
            return;
        }
        if (age.length() <= 0) {
            validated=false;
            showPopup(this, "Please enter an age");
            return;
        }
        int ageInt;
        try {
            ageInt = Integer.parseInt(age);
            if (ageInt <= 0) {
                validated=false;
                showPopup(this, "Please enter a valid age");
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
        } catch (NumberFormatException e) {
            // Makes sure that the height is a number
            validated=false;
            showPopup(this, "Please enter a valid height");
            return;
        }

        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);

        intent.putExtra("name", name);
        intent.putExtra("age", ageInt);
        intent.putExtra("weight", weightInt);
        intent.putExtra("height", heightInt);
    }
    public static void showPopup(Context context, String errorMessage) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
    }
}