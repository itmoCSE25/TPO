package org.example.model;

public class UltimateImp {

    private String uuid;
    private double power;
    private boolean isUsed = false;

    public UltimateImp(String uuid, double power) {
        this.uuid = uuid;
        this.power = power;
    }

    public UltimateImp() {
    }

    public String getUuid() {
        return uuid;
    }

    public UltimateImp setUuid(String uuid) {
        this.uuid = uuid;
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
}
