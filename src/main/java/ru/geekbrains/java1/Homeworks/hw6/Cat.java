package ru.geekbrains.java1.Homeworks.hw6;

public class Cat extends Animal {
    public Cat (String name, String color){super(name, color);}

    private final int maxLongSwim = 0;
    public final int maxLongRun = 200;

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
            System.out.printf("%s не плавает, он не пойдёт в воду, %s stoped.\n", name, name);
            return false;
        }else System.out.printf("%s проплыл %d метров\n", name, longSwim);
        return true;
    }
    @Override
    public void swim(){System.out.println("Коты не умеют плавать");}
}
