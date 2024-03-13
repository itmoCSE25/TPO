package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Clothes;
import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;
import org.example.model.enums.ClothesType;
import org.example.model.enums.PreferredPerson;

public class MoodService {

    public void moveImpsInPlace(
            Place place,
            List<UltimateImp> impList,
            PreferredPerson preferredPerson
    ) {
        List<Person> personList = new ArrayList<>(place.getPersonList());
        personList.sort(preferredPerson.getPersonComparator());
        int personIdx = 0;
        if (personList.isEmpty()) {
            return;
        }
        while (!impList.isEmpty() || personList.size() < personIdx) {
            if (!upPersonMoodLevel(personList.get(personIdx), impList.get(0))) {
                personIdx++;
            }
            impList.remove(0);
        }
    }

    private boolean upPersonMoodLevel(Person person, UltimateImp ultimateImp) {
        if (!doesPersonWearUnderwear(person)) {
            return false;
        }
        person.upMoodLevel(ultimateImp.getPower());
        if (person.getMoodLevel() >= person.getEnoughMoodLevel()) {
            person.loseUnderwear();
        }
        return true;
    }

    private boolean doesPersonWearUnderwear(Person person) {
        for (Clothes clothes : person.getClothesList()) {
            if (clothes.getClothesType() == ClothesType.UNDERWEAR) {
                return true;
            }
        }
        return false;
    }

}
