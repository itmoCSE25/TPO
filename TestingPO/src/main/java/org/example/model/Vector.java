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

    public int getId() {
        return id;
    }
}
