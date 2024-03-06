package org.example.model;

import java.util.List;

public class Place {

    private String placeName;
    private List<Person> personList;

    public Place(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
