package net.john_just.helper.enums;

public enum StockStatus {
    AVAILABLE("В наличии"),
    IN_DELIVERY("Заказан"),
    OUT_OF_STOCK("Отсутствует");

    private final String displayName;

    StockStatus(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
