package org.example.model;

import java.util.Objects;

import org.example.model.enums.ClothesType;

public class Clothes {

    private String name;
    private ClothesType clothesType;

    public Clothes(String name, ClothesType clothesType) {
        this.name = name;
        this.clothesType = clothesType;
    }

    public ClothesType getClothesType() {
        return clothesType;
    }

    @Override
    public boolean equals(Object o) {
        Clothes clothes = (Clothes) o;
        return Objects.equals(name, clothes.name) && clothesType == clothes.clothesType;
    }
}
