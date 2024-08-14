package com.example.fixitfitness;

import android.content.Context;
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
    public void handleSubmit (View view) {
        Log.d("2nd Activity", "The button is clicked");

        //need to get user edits from each of the text fields

        EditText nameEdit = findViewById(R.id.Name); //name edit
        EditText ageEdit = findViewById(R.id.Age); //age edit
        EditText weightEdit = findViewById(R.id.Weight); // weight edit
        EditText heightEdit = findViewById(R.id.Height); //height edit

        String name = nameEdit.getText().toString();
        String name = ageEdit.getText().toString();
        String name = weightEdit.getText().toString();
        String name = heightEdit.getText().toString();

        //validate the inputs
        // show error messages if applicable
        if (name.length() <= 0) {
            showPopup(this, "Please enter a name");
            return;
        }

        if (name.length() => 20) {
            showPopup(this, "Name is too long");
            return;
        }
        if (age.length() <= 0) {
            showPopup(this, "Please enter an age");
            return;
        }
        int ageInt;
        try {
            ageInt = Integer.parseInt(age);
            if (ageInt < 0) {
                showPopup(this, "Please enter a valid age");
                return;
            }
        } catch (NumberFormatException)
    }
    public static void showPopup(Context context, String errorMessage) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
    }
}