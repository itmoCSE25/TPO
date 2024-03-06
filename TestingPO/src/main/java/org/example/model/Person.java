package org.example.model;

import org.example.model.enums.PersonType;

public class Person {

    private String name;
    private double moodLevel = 0.0;

    private boolean wantToMoodGrade = false;
    private PersonType personType;

    public Person(String name, double moodLevel, boolean wantToMoodGrade, PersonType personType) {
        this.name = name;
        this.moodLevel = moodLevel;
        this.wantToMoodGrade = wantToMoodGrade;
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public double getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(double moodLevel) {
        this.moodLevel += moodLevel * personType.getKoff();
    }

    public boolean isWantToMoodGrade() {
        return wantToMoodGrade;
    }

    public PersonType getPersonType() {
        return personType;
    }
}
