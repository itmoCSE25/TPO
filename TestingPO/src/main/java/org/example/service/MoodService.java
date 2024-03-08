package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;
import org.example.model.enums.PreferredPerson;

public class MoodService {

    private final Double enoughMoodLevel;

    public MoodService(Double enoughMoodLevel) {
        this.enoughMoodLevel = enoughMoodLevel;
    }

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
            Person person = personList.get(personIdx);
            if (person.getMoodLevel() > enoughMoodLevel) {
                personIdx++;
                continue;
            }
            person.upMoodLevel(impList.get(0).getPower());
            impList.remove(0);
        }
    }

}
