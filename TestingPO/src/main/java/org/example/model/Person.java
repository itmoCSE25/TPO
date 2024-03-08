package org.example.model;

import org.example.model.enums.PersonType;

public class Person {

    private String name;

    private PersonType personType;

    private Double moodLevel = 0.0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Double getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(Double moodLevel) {
        this.moodLevel = moodLevel;
    }

    public void upMoodLevel(Double moodLevel) {
        this.moodLevel += moodLevel * personType.getKoff();
    }
}
