package ru.rahmetoff.java.core;

public class Robot implements Main.OvercomeObstacles {

    private String name;
    private int maxJumpHeight;
    private int maxRunDistance;

    public Robot(String name, int maxJumpHeight, int maxRunDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    public int run() {
        System.out.println("Робот " + name + " бежит");
        return maxRunDistance;
    }
    public int jump(){
        System.out.println("Робот " + name + " прыгает");
        return maxJumpHeight;
    }

}
