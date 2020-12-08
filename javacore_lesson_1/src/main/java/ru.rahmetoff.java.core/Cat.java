package ru.rahmetoff.java.core;

public class Cat implements Main.OvercomeObstacles {

    private String name;
    private int maxJumpHeight;
    private int maxRunDistance;

    public Cat(String name, int maxJumpHeight, int maxRunDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    public int run() {
        System.out.println("Кот " + name + " бежит");
        return maxRunDistance;
    }

    public int jump() {
        System.out.println("Кот " + name + " прыгает");
        return maxJumpHeight;
    }

}
