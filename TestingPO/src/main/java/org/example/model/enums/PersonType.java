package org.example.model.enums;

public enum PersonType {
    HOLERIC(1),
    MELANHOLIC(2),
    FLIGMATIC(3),
    SANGVINIC(4);

    private int koff;

    PersonType(int koff) {
        this.koff = koff;
    }

    public int getKoff() {
        return koff;
    }
}
