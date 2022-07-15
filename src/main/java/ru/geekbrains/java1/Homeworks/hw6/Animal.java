package ru.geekbrains.java1.Homeworks.hw6;

public class Animal {
    protected String name;
    protected String color;
    public String getName() {
        return name;
    }
    public Animal(String name, String color){
        this.name = name;
        this.color = color;
    }
    public void run(){System.out.printf("Animal %s run\n", name);}
    public void swim(){System.out.printf("Animal %s swim\n", name);}
    public void printInfo(){System.out.printf("Животное: %s, цвет %s\n", name, color);}
}
