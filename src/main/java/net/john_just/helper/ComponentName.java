package net.john_just.helper;

public class ComponentName {
    private String name;
    public ComponentName(String name) {
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
