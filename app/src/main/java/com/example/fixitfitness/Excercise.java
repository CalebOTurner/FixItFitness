package com.example.fixitfitness;

// This class represents an Exercise, with properties for name, reps, and sets.
public class Excercise {
    private String name;
    private String reps;
    private String sets;

    public Excercise(String name, String reps, String sets) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
    }

    public String getName() {
        return name;
    }
    public String getReps() {
        return reps;
    }
    public String getSets() {
        return sets;
    }
}
