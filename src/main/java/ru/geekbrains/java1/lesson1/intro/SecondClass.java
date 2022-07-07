package ru.geekbrains.java1.lesson1.intro;

public class SecondClass {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }
//2)
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }
//3)
    public static void checkSumSign(){
        int a = 5;
        int b = -7;
        int c = a + b;

        if (c >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();
    }

//3а
    public static boolean checkSumSign(int n, int m){
        return n + m >= 0;
    }
//4)
    public static void printColor(){
        int value = 160;

        if (value <= 0) {
            System.out.println("красный");
        }
        else if (value > 0 && value < 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
        System.out.println();
    }

//5)
    public static void compareNumbers(){
        int a = 20;
        int b = 180;

        if (a >= b) {
            System.out.println("a >= b");
        }

        else {
            System.out.println("a < b");
        }
    }

}
