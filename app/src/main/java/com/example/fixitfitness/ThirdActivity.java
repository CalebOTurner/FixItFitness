package com.example.fixitfitness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

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

        Intent intent = getIntent();
        String name = intent.getStringExtra( "name");
        int age = intent.getIntExtra("age", 0);
        int weight = intent.getIntExtra("weight", 0);
        int height = intent.getIntExtra("height", 0);

        TextView nameView = findViewById(R.id.textView7);

        // Height too low
        if (height < 120) {
            nameView.setText("You are too short to use this app");
            return;
        }

        // Height too low
        if (height > 220) {
            nameView.setText("You are too tall to use this app");
            return;
        }
    }

    private Plan> createPlan(int weight) {
        Plan plan = new Plan();

        //upper body
        Excercise dumbbellChestFly = new Excercise("Dumbbell Chest Fly", "6-8", "2");
        Excercise dumbbellBenchPress = new Excercise("Single Arm Dumbbell Row", "6-8 per arm","2");
        Excercise dumbbellTricepExtension = new Excercise("Overhead Tricep Extension", "6-8","2");
        Excercise dumbbellHammerCurl = new Excercise("Dumbbell Hammer Curl", "6-8","2");
        Excercise dumbbellLatRaise = new Excercise("Dumbbell Lat Raise","6-8","2");

        //lower body
        Excercise bulgarianSplitSquat = new Excercise("Bulgarian Split Squat", "6-8 per leg", "2");
        Excercise weightedRDL = new Excercise("Weighted RDL", "6-8","2");
        Excercise gobletSquat = new Excercise("Goblet Squat", "6-8","2");
        Excercise boxJump = new Excercise("Box Jump", "8-12","2");
        Excercise walkingLunges = new Excercise("Walking Lunges","8-12","2");



        if (weight < 65) {
            plan.addExcercise(dumbbellChestFly);
            plan.addExcercise(dumbbellBenchPress);
            plan.addExcercise(dumbbellTricepExtension);
            plan.addExcercise(dumbbellHammerCurl);
            plan.addExcercise(dumbbellLatRaise);

        } else if (weight < 73) {
            plan.addExcercise(dumbbellChestFly);
            plan.addExcercise(dumbbellBenchPress);
            plan.addExcercise(dumbbellTricepExtension);
            plan.addExcercise(walkingLunges);
            plan.addExcercise(boxJump);

        } else if (weight < 81) {
            plan.addExcercise(bulgarianSplitSquat);
            plan.addExcercise(weightedRDL);
            plan.addExcercise(gobletSquat);
            plan.addExcercise(dumbbellHammerCurl);
            plan.addExcercise(dumbbellLatRaise);

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