package ru.geekbrains.java1.Homeworks.hw6;

public class Dog extends Animal {
        public Dog (String name, String color){
            super(name, color);
        }
    private int maxLongRun = 500;
    private int maxLongSwim = 10;

    public int getMaxLongSwim() {
        return maxLongSwim;
    }

    public int getMaxLongRun() {
        return maxLongRun;
    }

    public boolean run(int longRun){
        if (longRun > maxLongRun) {
            System.out.printf("Всё, не добежал %s ((((\n", name);
            return false;
        }else System.out.printf("%s пробежал %d метров\n", name, longRun);
        return true;
    }

    public boolean swim(int longSwim){
        if (longSwim > maxLongSwim){
            System.out.printf("К сожалению, %s утонул...\n", name);
            return false;
        }else System.out.printf("%s проплыл %d метров\n", name, longSwim);
        return true;
    }
}

