package org.example.model;

import java.util.Objects;

public class UltimateImp {

    private String name;
    private double power;
    private boolean isUsed = false;

    public UltimateImp(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public UltimateImp(String name, double power, boolean isUsed) {
        this.name = name;
        this.power = power;
        this.isUsed = isUsed;
    }

    public double getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        UltimateImp that = (UltimateImp) o;

        return Objects.equals(name, that.name);
    }
}
