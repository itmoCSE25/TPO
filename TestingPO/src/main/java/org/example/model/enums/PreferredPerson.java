package org.example.model.enums;

import java.util.Comparator;

import org.example.model.Person;

public enum PreferredPerson {
    WITH_LOW_MOOD((o1, o2) -> (int) (o1.getMoodLevel() - o2.getMoodLevel())),
    EASY_TO_MOOD_UP(Comparator.comparingInt(o -> o.getPersonType().getKoff()));

    private final Comparator<Person> personComparator;

    PreferredPerson(Comparator<Person> personComparator) {
        this.personComparator = personComparator;
    }

    public Comparator<Person> getPersonComparator() {
        return personComparator;
    }
}
