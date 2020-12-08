package ru.rahmetoff.java.core;

public class Main {

    interface OvercomeObstacles {
        int run();
        int jump();
    }

    interface Obstacle {
        boolean result(int maxValue);
    }

    public static void main(String[] args) {

        Man man = new Man("Хан", 1500, 3500);
        Cat cat = new Cat("Чубакка", 1000, 1500);
        Robot robot = new Robot("R2D2", 100, 100000);

        Track track = new Track(3000);
        Wall wall = new Wall(500);

        OvercomeObstacles[] someoneOvercome = {man, cat, robot};
        Obstacle[] obstacles = {track, wall};

        for (OvercomeObstacles e : someoneOvercome) {
            for (Obstacle i : obstacles) {
                if (i == track) {
                    if (i.result(e.run()) == false) {
                        break;}
                } else i.result(e.jump());
            }
        }
    }
}
