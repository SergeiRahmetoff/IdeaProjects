package ru.rahmetoff.java.core;

public class Wall implements Main.Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean result(int maxJumpHeight) {
        if (height <= maxJumpHeight) {
            System.out.println("Перепрыгнул " + (height / 100) + " сантиметров");
            return true;
        } else {
            System.out.println("Не перепрыгнул " + (height / 100) + " сантиметров");
            return false;
        }
    }

}

