package ru.netology.task2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        try (Scanner scanner = new Scanner(System.in)) {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");

            System.out.print("Введите размер списка: ");
            int sizeList = scanner.nextInt();

            System.out.print("Введите верхнюю границу для значений: ");
            int upperBound = scanner.nextInt();

            List<Integer> list = ListMaker.makeList(sizeList, upperBound);
            System.out.print("Вот случайный список: ");
            list.forEach((element) -> {
                System.out.print(element + " ");
            });

            System.out.println();
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int filterThreshold = scanner.nextInt();
            Filter filter = new Filter(filterThreshold);
            List<Integer> result = filter.filterOut(list);

            logger.log("Выводим результат на экран");
            System.out.print("Отфильтрованный список: ");
            result.forEach((element) -> {
                System.out.print(element + " ");
            });

            System.out.println();
            logger.log("Завершаем программу");
        }
    }
}
