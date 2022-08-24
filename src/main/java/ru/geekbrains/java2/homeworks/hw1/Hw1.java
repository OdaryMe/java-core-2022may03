package ru.geekbrains.java2.homeworks.hw1;

public class Hw1 {
    public static void main(String[] args) {
        Unit[] units = {
                new Robot("R0362", 500_000, 30),
                new Human("Ivan", 40_000, 180),
                new Cat("Simon", 200, 300),
                new Robot("000AI362", 10_000, 15),
                new Human("Bob", 1000, 80),
                new Cat("Tom", 1500, 200)
           };
        for (Unit unit : units) {
            unit.run();
            unit.jump();
        }
        System.out.println("\n\nMarathon!\n");

        Obstacle[] obstacles = {
                new Runtrack(100),
                new Wall(25),
                new Runtrack(500),
                new Wall(50),
                new Runtrack(1000),
                new Wall(150)
        };
        for (Unit unit : units) {
            for (Obstacle obstacle : obstacles) {
                //unit.overcome(obstacle);
                if (!unit.overcome(obstacle)) break;
            }
        }
    }
}
