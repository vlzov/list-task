package ru.vlzov.java.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> casesList = new ArrayList<>();
        int choice;
        String caseInput;

        while(true) {
            System.out.println("Выберите операцию\n");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    caseInput = scanner.nextLine();

                    casesList.add(caseInput);

                    showCases(casesList);
                    
                    System.out.println();
                    break;
                
                case 2:
                    if(casesList.isEmpty()) {
                        System.out.println("Список дел пуст!");
                        break;
                    }

                    showCases(casesList);
                    System.out.println();
                    break;

                case 3:
                    if(casesList.isEmpty()) {
                        System.out.println("Список дел пуст!");
                        break;
                    }

                    System.out.print("Введите номер для удаления: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if(choice < 1 || choice > casesList.size()) {
                        System.out.println("Ошбика: дела с индексом " + choice + " не существует!");
                        break;
                    }

                    casesList.remove(choice - 1);
                    System.out.println("Удалено!");

                    showCases(casesList);
                    System.out.println();
                    break;

                case 4:
                    if(casesList.isEmpty()) {
                        System.out.println("Список дел пуст!");
                        break;
                    }

                    System.out.print("Введите название для удаления: ");
                    caseInput = scanner.nextLine();

                    boolean wasRemoved = casesList.remove(caseInput);

                    if(!wasRemoved) {
                        System.out.println("Ошибка: дела с названием " + caseInput + " не сущетсвует!");
                        break;
                    }

                    System.out.println("Удалено!");
                    
                    showCases(casesList);
                    System.out.println();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Введено неверное значение!");;
            }
        }
    }

    public static void showCases(List<String> list) {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), list.get(i));
        }
    }
}
