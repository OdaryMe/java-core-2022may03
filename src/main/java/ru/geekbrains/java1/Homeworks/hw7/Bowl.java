package ru.geekbrains.java1.Homeworks.hw7;

import java.util.Scanner;

public class Bowl {
    private static final Scanner SCANNER = new Scanner(System.in);
    private int foodAmount;

    public void putFood(int amount) {
        System.out.printf("Enter the amount of food (g) >>> ");
        amount = SCANNER.nextInt();
        this.foodAmount += amount;
    }

    public void decreaseFood(int amount) {
        if (foodAmount < amount) {
            System.out.println("There is not enough food in the bowl.");
        }else this.foodAmount -= amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
