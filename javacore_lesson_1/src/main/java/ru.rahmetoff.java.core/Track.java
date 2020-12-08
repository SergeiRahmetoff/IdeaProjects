package ru.rahmetoff.java.core;

public class Track implements Main.Obstacle {

    private int length;

    public Track(int length) {
        this.length = length;
    }

    public boolean result(int maxRunDistance) {
        if (length <= maxRunDistance) {
            System.out.println("Пробежал дистанцию " + length + " метров");
            return true;
        } else {
            System.out.println("Не пробежал дистанцию " + length + " метров");
            return false;
        }
    }

}
