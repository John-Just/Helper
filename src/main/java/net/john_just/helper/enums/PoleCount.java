package net.john_just.helper.enums;

public enum PoleCount {
    P1("1P"),
    P2("2P"),
    P3("3P"),
    P4("4P");

    private final String label;

    PoleCount(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
