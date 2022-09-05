package ru.geekbrains.java2.homeworks.hw1;

public class Cat extends Unit {
     Cat(String name, int maxRun, int maxJump) {
         super("Cat", name, maxRun, maxJump);
     }
    @Override
    public void jump() {
        System.out.println("The cat jumps");
    }


        @Override
    public void run() {
        System.out.println("The cat runs");
    }

}