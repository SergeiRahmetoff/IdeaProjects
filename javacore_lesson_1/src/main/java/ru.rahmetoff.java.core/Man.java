package ru.rahmetoff.java.core;

public class Man implements Main.OvercomeObstacles {

    private String name;
    private int maxJumpHeight;
    private int maxRunDistance;

    public Man(String name, int maxJumpHeight, int maxRunDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    public int run() {
        System.out.println("Человек " + name + " бежит");
        return maxRunDistance;
    }

    public int jump() {
        System.out.println("Человек " + name + " прыгает");
        return maxJumpHeight;
    }

}
