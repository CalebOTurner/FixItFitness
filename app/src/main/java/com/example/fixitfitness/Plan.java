package com.example.fixitfitness;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Plan {
    private ArrayList<Excercise> plan;

    public Plan() {
        plan = new ArrayList<>();
    }

    public void addExcercise(Excercise excercise) {
        plan.add(excercise);
    }

    public ArrayList<Excercise> getPlan() {
        return plan;
    }
}
