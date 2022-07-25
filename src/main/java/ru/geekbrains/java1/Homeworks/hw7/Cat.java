package ru.geekbrains.java1.Homeworks.hw7;

import java.util.Arrays;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    private Flea[] fleas;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() == 0) {
            System.out.printf("The bowl is empty. Add %d of food for %s.\n", this.appetite, this.name);
            return;
        } else if (bowl.getFoodAmount() < this.appetite) {
            int delta = this.appetite - bowl.getFoodAmount();
            System.out.printf("%s is not satisfied, it needs more, add %d g more for %s.\n",
                    this.name, delta, this.name);
            return;
        } else bowl.decreaseFood(this.appetite);
        satiety = true;
        System.out.printf("Cat %s ate some food: %d g. %s is full.\n", this.name, this.appetite, this.name);
    }

    public void setFleas(Flea[] fleas) {
        this.fleas = fleas;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public Flea[] getFleas() {
        return fleas;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", fleas=" + Arrays.toString(fleas) +
                '}';
    }
}
