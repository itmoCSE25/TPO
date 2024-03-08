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

    public String getName() {
        return name;
    }

    public UltimateImp setName(String name) {
        this.name = name;
        return this;
    }

    public double getPower() {
        return power;
    }

    public UltimateImp setPower(double power) {
        this.power = power;
        return this;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UltimateImp that = (UltimateImp) o;

        if (Double.compare(that.power, power) != 0) {
            return false;
        }
        if (isUsed != that.isUsed) {
            return false;
        }
        return Objects.equals(name, that.name);
    }
}
