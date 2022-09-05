package ru.geekbrains.java2.homeworks.hw1;

public class Human extends Unit {
    Human(String name, int maxRun, int maxJump) {
        super("Human", name, maxRun, maxJump);
    }
    @Override
    public void jump() {
        System.out.println("The human jumps");
    }

//    @Override
//    public boolean jump(int barrier){
//       return true;
//    }


    @Override
    public void run() {
        System.out.println("The human runs");
    }

//    @Override
//    public boolean run(int distance){
//        return true;
//    }

}
