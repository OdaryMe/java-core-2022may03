package ru.geekbrains.java1.Homeworks;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(checkSumSpan(9, 8));
        positiveOrNegative(-5);
        System.out.println(negative(0));
        urge("My precious-s-s-s!", 5);
        System.out.println(leapYear(2024));
    }

    public static boolean checkSumSpan(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }

    public static void positiveOrNegative(int a) {
        if (a >= 0){
            System.out.println("Это положительное число");
        }else {
            System.out.println("Это отрицательное число");
        }
    }

    public static boolean negative(int a) {
        return a < 0;
    }

    public static void urge(String Text, int a){
        for (int i = 1; i <= a; i++) {
            System.out.println(Text);
        }
    }
    public static boolean leapYear(int year){ //хотела написать через switch, не получилось
            if (year % 400 == 0){
                return true;
            } else if (year % 100 == 0) {
                return false;
            } else if (year % 4 == 0) {
                return true;
            }return false;
    }
}
