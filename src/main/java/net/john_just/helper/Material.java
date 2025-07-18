package net.john_just.helper;

public class Material {

    private String name;
    private int quantity;
    private String unit;

    public Material(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public void addQuantity (int q) {
        this.quantity += q;
    }

    public void removeQuantity (int q) {
        if (this.quantity >= q) {
            this.quantity -= q;
        }
        else {
            System.out.println("Материала недостаточно!");
        }
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " " + unit + ")";
    }
}
