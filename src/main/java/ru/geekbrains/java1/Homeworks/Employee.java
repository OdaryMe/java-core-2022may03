package ru.geekbrains.java1.Homeworks;

public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;

    public int getAge() {
        return age;
    }

    private int age;

    public Employee (String surname, String name, String patronymic, String position, String email, String phoneNumber, float salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("Сотрудник:\nФИО: %s %s %s\nЗанимаемая должность: %s\nэлектронный адрес: %s\nКонтактный номер: %s\nОклад: $%f\nВозраст: %d", this.surname, this.name, this.patronymic, this.position, this.email, this.phoneNumber, this.salary, this.age);
    }
}
