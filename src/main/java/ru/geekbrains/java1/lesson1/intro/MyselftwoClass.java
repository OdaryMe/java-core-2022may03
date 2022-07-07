package ru.geekbrains.java1.lesson1.intro;

import java.util.Scanner;

public class MyselftwoClass {
    public static void main(String[] args) {
        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        System.out.println("Введите 1-е число");
        int a = scanner.nextInt();
        System.out.println("Введите 2-е число");
        int b = scanner.nextInt();
        int result;
        if (operation == 1) {
            result = a + b;

        }   else if(operation == 2){
            result = a - b;
        }   else if(operation == 3){
            result = a * b;
        }
        else{
            result = a / b;
        }

        System.out.println("Результат = " + result);
    }
}



