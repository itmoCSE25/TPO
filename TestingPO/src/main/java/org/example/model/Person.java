package org.example.model;

public class Person {

    private String name;
    private double moodLevel = 0.0;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Double moodLevel) {
        this.name = name;
        this.moodLevel = moodLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(double moodLevel) {
        this.moodLevel += moodLevel;
    }
}
