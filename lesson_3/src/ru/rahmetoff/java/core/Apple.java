package ru.rahmetoff.java.core;

public class Apple extends Fruit{
    private String name;
    private double weight = 1.0;
    boolean inBox = false;

    public Apple(String name) {
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
