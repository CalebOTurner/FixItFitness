package com.example.fixitfitness;

import java.lang.reflect.Array;
import java.util.ArrayList;

// This class represents a workout plan, which consists of a list of exercises (Exercise objects).
public class Plan {
    private ArrayList<Excercise> plan;

    // Creates an empty ArrayList for exercises
    public Plan() {
        plan = new ArrayList<>();
    }
    // Method to add an exercise to the plan
    public void addExcercise(Excercise excercise) {
        plan.add(excercise);
    }


    // Method to retrieve the entire list of exercises in the plan
    public ArrayList<Excercise> getPlan() {
        return plan;
    }
}
