package ru.netology.task2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListMaker {
    public static List<Integer> makeList(int sizeList, int upperBound) {
        Logger logger = Logger.getInstance();
        logger.log("Создаём и наполняем список");
        return new Random()
                .ints(0, upperBound)
                .limit(sizeList)
                .boxed()
                .collect(Collectors.toList());
    }
}
