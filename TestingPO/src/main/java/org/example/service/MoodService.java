package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.model.Person;
import org.example.model.Place;
import org.example.model.UltimateImp;

public class MoodService {

    public void changeMoodInPlace(Place place, List<UltimateImp> impList) {
        place.getPersonList().forEach(person -> changePersonMoodLevel(person, impList));
    }

    private void changePersonMoodLevel(Person person, List<UltimateImp> impList) {
        Optional<UltimateImp> ultimateImp = impList.stream().filter(imp -> !imp.isUsed()).findFirst();
        if (ultimateImp.isEmpty()) {
            return;
        }
        person.setMoodLevel(ultimateImp.get().getPower());
        ultimateImp.get().setUsed(true);
    }
}
