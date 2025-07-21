package net.john_just.helper.enums;

public enum CrossSection {
    MM0_5(0.5),
    MM0_75(0.75),
    MM1(1),
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

    @Override
    public String toString() {
        return getValue() + "мм²";
    }
}

