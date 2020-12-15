package ru.rahmetoff.java.core;

public class Orange extends Fruit{
    private String name;
    private double weight = 1.5;
    boolean inBox = false;

    public Orange(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return name;
    }
}
