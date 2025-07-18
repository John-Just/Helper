package net.john_just.helper.enums;

public enum WireColor {
    RED("Красный"),
    BLUE("Синий"),
    BLACK("Черный"),
    GREEN_YELLOW("Желто-зеленый"),
    WHITE("Белый");

    private final String title;

    WireColor(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
