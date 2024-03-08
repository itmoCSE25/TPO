package org.example.model.enums;

public enum ImpType {
    SIMPLE(1),
    AVERAGE(3),
    DIFFICULT(5);

    private int count;

    ImpType(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
