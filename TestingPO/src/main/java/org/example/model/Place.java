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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
