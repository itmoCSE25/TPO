package org.example.service;

import java.util.List;

import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;
import org.example.model.enums.PreferredPerson;

public class MoodService {

    public void moveImpsInPlace(
            Place place,
            List<UltimateImp> impList,
            PreferredPerson preferredPerson,
            Double enoughMoodLevel
    ) {
        List<Person> personList = place.getPersonList();
        personList.sort(preferredPerson.getPersonComparator());
        int personIdx = 0;
        while (!impList.isEmpty() || personList.size() < personIdx) {
            Person person = personList.get(personIdx);
            if (person.getMoodLevel() > enoughMoodLevel) {
                personIdx++;
            }
            person.upMoodLevel(impList.get(0).getPower());
            impList.remove(0);
        }
    }

}
