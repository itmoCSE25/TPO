package org.example.model;

import java.util.List;

public class Place {

    private String placeName;
    private List<Person> personList;
    private long maxPersonsCount;

    public Place(List<Person> personList, long maxPersonsCount) {
        this.personList = personList;
        this.maxPersonsCount = maxPersonsCount;
    }

    public Place(String name, List<Person> personList, long maxPersonsCount) {
        this.placeName = name;
        this.personList = personList;
        this.maxPersonsCount = maxPersonsCount;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public long getMaxPersonsCount() {
        return maxPersonsCount;
    }

    public void setMaxPersonsCount(long maxPersonsCount) {
        this.maxPersonsCount = maxPersonsCount;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
