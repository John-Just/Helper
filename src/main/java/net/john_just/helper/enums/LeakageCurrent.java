package net.john_just.helper.enums;

public enum LeakageCurrent {
    MA_10("10 мА"),
    MA_30("30 мА"),
    MA_100("100 мА"),
    MA_300("300 мА");

    private final String label;

    LeakageCurrent(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
