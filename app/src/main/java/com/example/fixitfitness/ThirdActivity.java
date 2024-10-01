package com.example.fixitfitness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    // Enables the edge-to-edge display of the app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_three);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Retrieve the data passed from the previous activity (SecondActivity)
        Intent intent = getIntent();
        String name = intent.getStringExtra( "name");
        int age = intent.getIntExtra("age", 0);
        int weight = intent.getIntExtra("weight", 0);
        int height = intent.getIntExtra("height", 0);

        showPlan(weight);
    }
    // Call the method to display the workout plan based on the user's weight
    private void showPlan(int weight) {
        // Create a workout plan based on the user's weight
        Plan plan = createPlan(weight);
        // Reference to the table layout in the activity layout to display the exercises
        TableLayout table = findViewById(R.id.Table);

        // Loop through each exercise in the plan and add a row for each exercise
        for(Excercise excercise : plan.getPlan()) {
            TableRow row = createRow(excercise);
            table.addView(row);
        }

    }
    // Create a new row for each exercise
    private TableRow createRow(Excercise excercise) {
        TableRow row = new TableRow(this);
    // Create a TextView for the exercise name and set up colours
        TextView name = new TextView(this);
        //Padding of 6px
        name.setPadding(6, 6, 6, 6);
        name.setText(excercise.getName());
        name.setTextColor(0xFFFFFFFF);
        row.addView(name);

        TextView reps = new TextView(this);
        reps.setPadding(6, 6, 6, 6);
        // Create a TextView for the exercise reps
        reps.setText(excercise.getReps());
        reps.setTextColor(0xFFFFFFFF);
        row.addView(reps);
        // Create a TextView for the exercise sets
        TextView sets = new TextView(this);
        sets.setPadding(6, 6, 6, 6);
        sets.setText(excercise.getSets());
        sets.setTextColor(0xFFFFFFFF);
        row.addView(sets);

        return row;
    }

    // Create a new workout plan
    private Plan createPlan(int weight) {
        Plan plan = new Plan();

        //upper body
        Excercise dumbbellChestFly = new Excercise("Dumbbell Chest Fly", "2", "6-8");
        Excercise dumbbellBenchPress = new Excercise("Single Arm Dumbbell Row", "2","6-8 per arm");
        Excercise dumbbellTricepExtension = new Excercise("Overhead Tricep Extension", "2","6-8");
        Excercise dumbbellHammerCurl = new Excercise("Dumbbell Hammer Curl", "2","6-8");
        Excercise dumbbellLatRaise = new Excercise("Dumbbell Lat Raise","2","6-8");

        //lower body
        Excercise bulgarianSplitSquat = new Excercise("Bulgarian Split Squat", "2", "6-8 per leg");
        Excercise weightedRDL = new Excercise("Weighted RDL", "2","6-8");
        Excercise gobletSquat = new Excercise("Goblet Squat", "2","6-8");
        Excercise boxJump = new Excercise("Box Jump", "2","8-12");
        Excercise walkingLunges = new Excercise("Walking Lunges","2","8-12");


        // Customize the workout plan based on the user's weight
        // For users weighing less than 65 kg
        if (weight < 65) {
            plan.addExcercise(dumbbellChestFly);
            plan.addExcercise(dumbbellBenchPress);
            plan.addExcercise(dumbbellTricepExtension);
            plan.addExcercise(dumbbellHammerCurl);
            plan.addExcercise(dumbbellLatRaise);

            // For users weighing between 65 and 73 kg
        } else if (weight < 73) {
            plan.addExcercise(dumbbellChestFly);
            plan.addExcercise(dumbbellBenchPress);
            plan.addExcercise(dumbbellTricepExtension);
            plan.addExcercise(walkingLunges);
            plan.addExcercise(boxJump);

            // For users weighing between 73 and 81 kg
        } else if (weight < 81) {
            plan.addExcercise(bulgarianSplitSquat);
            plan.addExcercise(weightedRDL);
            plan.addExcercise(gobletSquat);
            plan.addExcercise(dumbbellHammerCurl);
            plan.addExcercise(dumbbellLatRaise);

            // For users weighing between 81 and 90 kg
        } else if (weight < 90) {
            plan.addExcercise(bulgarianSplitSquat);
            plan.addExcercise(weightedRDL);
            plan.addExcercise(gobletSquat);
            plan.addExcercise(boxJump);
            plan.addExcercise(walkingLunges);

        }

        return plan;
    }
}