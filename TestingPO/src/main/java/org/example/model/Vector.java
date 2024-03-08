package org.example.model;

import org.example.model.enums.OrientationType;

public class Vector {

    private int id;

    private double weight;

    private OrientationType orientationType;

    public Vector(int id, double weight, OrientationType orientationType) {
        this.id = id;
        this.weight = weight;
        this.orientationType = orientationType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public OrientationType getOrientationType() {
        return orientationType;
    }

    public void setOrientationType(OrientationType orientationType) {
        this.orientationType = orientationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
