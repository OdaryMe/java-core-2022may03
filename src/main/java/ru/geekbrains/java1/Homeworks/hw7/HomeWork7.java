package ru.geekbrains.java1.Homeworks.hw7;

import ru.geekbrains.java1.Homeworks.hw6.Animal;
import ru.geekbrains.java1.Homeworks.hw6.Dog;

public class HomeWork7 {
    public static void main(String[] args) {
        catsAndBowls();
   //     fight();
    }

    private static void fight() {
        Fighter fighter1 = new Fighter("Sub-Zero", 100, 15);
        Fighter fighter2 = new Fighter("Scorpion", 115, 13);

        while (true){
            fighter1.hit(fighter2);
            if (fighter2.getHealth() <= 0) {
                System.out.println(fighter2 + " dead");
                break;
            }
            fighter2.hit(fighter1);
            if (fighter1.getHealth() <= 0) {
                System.out.println(fighter2 + " dead");
                break;
            }
        }
    }

    private static void catsAndBowls() {
        Cat[] cats = {
                new Cat("Barsik", 10, false),
                new Cat("Murzik", 20, false),
                new Cat("Tom", 15, false),
                new Cat("Leopold", 25, false)
        };
        Bowl bowl = new Bowl();
        System.out.println("The cats need to be fed. Put some food for them.");
        bowl.putFood(bowl.getFoodAmount());

        for (Cat cat : cats) {
            System.out.printf("There is %d g of food in the bowl\n", bowl.getFoodAmount());
            cat.eat(bowl);
            while (bowl.getFoodAmount() < cat.getAppetite() && !cat.isSatiety()){
                bowl.putFood(bowl.getFoodAmount());
                System.out.printf("There is %d g of food in the bowl\n", bowl.getFoodAmount());
                cat.eat(bowl);
            }
        }
        System.out.println("\nThank you! All cats were fed.");
    }
}
