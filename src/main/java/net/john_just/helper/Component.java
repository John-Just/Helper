package net.john_just.helper;

import net.john_just.helper.enums.StockStatus;

public abstract class Component {
    protected ComponentName name;
    protected Manufacturer manufacturer;  // Производитель
    protected double price;
    protected int quantity;
    protected StockStatus stockStatus;
    protected String description;

    public Component(ComponentName name, Manufacturer manufacturer, double price, int quantity,
                     StockStatus stockStatus) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.stockStatus = stockStatus;
        this.description = "";
    }

    public abstract String getInfo();

    public ComponentName getName() {
        return name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
