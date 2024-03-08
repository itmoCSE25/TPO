package org.example.model;

import java.util.Objects;

import org.example.model.enums.PersonType;

public class Person {

    private String name;

    private PersonType personType;

    private Double moodLevel = 0.0;

    public Person(String name, PersonType personType, Double moodLevel) {
        this.name = name;
        this.personType = personType;
        this.moodLevel = moodLevel;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) {
            return false;
        }
        if (personType != person.personType) {
            return false;
        }
        return Objects.equals(moodLevel, person.moodLevel);
    }
}
