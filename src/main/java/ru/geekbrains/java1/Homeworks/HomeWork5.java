package ru.geekbrains.java1.Homeworks;

public class HomeWork5 {
    public static void main(String[] args) {
        Employee employee = new Employee("Иванов", "Карл", "Иванович", "Глвный бухгалтер", "ivanov@plant.com", "89253250145", 3000.00F, 45);
        employee.printInfo();
        System.out.println();
        System.out.println();

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Малинин", "Марк", "Ильич", "Главный инженер", "malinin@plant.com", "89314562832", 3500f, 33);
        employees[1] = new Employee("Сигурдиди", "Тамара", "Ивановна", "Бухгалтер", "sigurdidi@plant.com", "89314325834", 1830f, 53);
        employees[2] = new Employee("Клагина", "Марина", "Петровна", "Сисадмин", "klaghina@plant.com", "89314547932", 4293f, 39);
        employees[3] = new Employee("Петрова", "Светлана", "Кировна", "Менеджер по продажам", "petrova@plant.com", "89314514735", 990f, 43);
        employees[4] = new Employee("Ухова", "Анна", "Карловна", "Аналитик", "uklova@plant.com", "89314566510", 3500f, 33);
        for (Employee value : employees) {
            if (value.getAge() >= 40) {
                value.printInfo();
                System.out.println();
                System.out.println();
            }
        }
    }
}
