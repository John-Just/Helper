package net.john_just.helper;

public class ModelName {
    private String name;
    public ModelName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
