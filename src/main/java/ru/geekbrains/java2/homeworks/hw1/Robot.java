package ru.geekbrains.java2.homeworks.hw1;

public class Robot extends Unit {
    Robot(String name, int maxRun, int maxJump) {
        super("Robot", name, maxRun, maxJump);
    }
    @Override
    public void jump() {
        System.out.println("The robot jumps");

    }

    @Override
    public void run() {
        System.out.println("The robot runs");
    }


}
