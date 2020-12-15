package ru.rahmetoff.java.core;

public abstract class Fruit extends Object{
    private String name;
    double weight;
    boolean inBox;

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {

        return getClass().getName() ;
    }
}
