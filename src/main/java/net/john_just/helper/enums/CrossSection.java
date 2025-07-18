package net.john_just.helper.enums;

public enum CrossSection {
    MM1_5(1.5),
    MM2_5(2.5),
    MM4(4.0),
    MM6(6.0),
    MM10(10.0);

    private final double value;

    CrossSection(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

