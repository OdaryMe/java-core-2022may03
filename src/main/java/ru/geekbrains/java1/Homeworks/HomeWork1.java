package ru.geekbrains.java1.Homeworks;

public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println("Hi!");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
        public static void printThreeWords() {
            System.out.println("Orange\nBanana\nApple");
        }

        public static void checkSumSign() {
            int a = 0;
            int b = -3;
            if (a + b >= 0) {
                System.out.println("Сумма положительная");
            }
            else {
                System.out.println("Сумма отрицательная");
            }
        }


        public static void printColor() {
            int value = -101;
            if (value <= 0) {
                System.out.println("Красный");
            }
            else if (value < 100) {
                System.out.println("Желтый");
            }
            else {
                System.out.println("Зеленый");
            }
        }

        public static void compareNumbers() {
            int a = 15;
            int b = 70;
            if (a >= b) {
                System.out.println("a >= b");
            }else {
                System.out.println("a < b");
            }
        }

}
