package org.example.model;

public class Schema {

    private String name;
    private long countOfVectors;
    private boolean isNotUsed;

    public Schema(String name, long countOfVectors, boolean isNotUsed) {
        this.name = name;
        this.countOfVectors = countOfVectors;
        this.isNotUsed = isNotUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountOfVectors() {
        return countOfVectors;
    }

    public void setCountOfVectors(long countOfVectors) {
        this.countOfVectors = countOfVectors;
    }

    public boolean isNotUsed() {
        return isNotUsed;
    }

    public void setNotUsed(boolean notUsed) {
        isNotUsed = notUsed;
    }
}
