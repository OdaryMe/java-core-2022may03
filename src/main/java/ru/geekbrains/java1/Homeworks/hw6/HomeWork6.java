package ru.geekbrains.java1.Homeworks.hw6;

import java.util.Objects;

public class HomeWork6 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Барсик", "белый"),
                new Dog("Бобик", "черный")
        };
        int catCount = 0;
        int dogCount = 0;

        Barrier[] barriers = {
                new Barrier("Road", 20),
                new Barrier("Road", 200),
                new Barrier("Riva", 10),
                new Barrier("Road", 240),
                new Barrier("Lake", 300),
                new Barrier("Road", 550)
        };

        for (int i = 0; i < animals.length; i++) {
            if (Objects.equals(animals[i].getName(),"Бобик")){
                ((Dog)animals[i]).run(20);
            }
            if (animals[i] instanceof Cat) {
                ((Cat)animals[i]).run(38);
                ((Cat)animals[i]).swim(20);
                catCount++;
            }
            if (animals[i] instanceof Dog) {
                ((Dog)animals[i]).run(600);
                ((Dog)animals[i]).swim(20);
                dogCount++;
            }
        } System.out.println("\nКоличество котов всего: " + catCount);
        System.out.println("Количество собак всего: " + dogCount);

        System.out.println("\nБЕГ С ПРЕПЯТСТВИЯМИ!\n");
        for (int i = 0; i < animals.length; i++){
            for (int j = 0; j < barriers.length; j++){
                if (barriers[j].getKind().equals("Riva") || barriers[j].getKind().equals("Lake")){
                    int longSwim = barriers[j].getMeter();

                        if (animals[i] instanceof Dog){
                            ((Dog)animals[i]).swim(longSwim);
                            if (longSwim > ((Dog) animals[i]).getMaxLongSwim()) break;
                            }

                        if (animals[i] instanceof Cat){
                            ((Cat)animals[i]).swim(longSwim);
                            if (longSwim > ((Cat) animals[i]).getMaxLongSwim()) break;
                        }
                }else {
                    int longRun = barriers[j].getMeter();

                    if (animals[i] instanceof Dog){
                        ((Dog)animals[i]).run(longRun);
                        if (longRun > ((Dog) animals[i]).getMaxLongRun()) break;
                    }
                    if (animals[i] instanceof Cat){
                        ((Cat)animals[i]).run(longRun);
                        if (longRun > ((Cat) animals[i]).getMaxLongRun()) break;}
                }
            }
        }
    }
}
