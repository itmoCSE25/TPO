package org.example.model;

import java.util.List;
import java.util.Objects;

import org.example.model.enums.ClothesType;
import org.example.model.enums.PersonType;

public class Person {

    private String name;

    private PersonType personType;

    private Double moodLevel = 0.0;
    private Double enoughMoodLevel;

    private List<Clothes> clothesList;

    public Person(String name, PersonType personType, Double moodLevel, Double enoughMoodLevel, List<Clothes> clothesList) {
        this.name = name;
        this.personType = personType;
        this.moodLevel = moodLevel;
        this.enoughMoodLevel = enoughMoodLevel;
        this.clothesList = clothesList;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public Double getMoodLevel() {
        return moodLevel;
    }

    public void upMoodLevel(Double moodLevel) {
        this.moodLevel += moodLevel * this.getPersonType().getKoff();
    }

    public Double getEnoughMoodLevel() {
        return enoughMoodLevel;
    }

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void loseUnderwear() {
        this.clothesList = this.getClothesList().stream()
                .filter(clothes -> clothes.getClothesType() != ClothesType.UNDERWEAR)
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return Objects.equals(name, person.name) && personType == person.personType && Objects.equals(moodLevel,
                person.moodLevel) && Objects.equals(enoughMoodLevel, person.enoughMoodLevel) && Objects.equals(clothesList, person.clothesList);
    }
}
