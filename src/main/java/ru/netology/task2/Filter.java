package ru.netology.task2;

import java.util.List;

public class Filter {
    private int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        int sizeBeforeFiltering = source.size();

        source.removeIf(element -> {
            if (element > treshold) {
                logger.log("Элемент \"" + element + "\" проходит");
                return false;
            } else {
                logger.log("Элемент \"" + element + "\" не проходит");
                return true;
            }
        });
        logger.log("Прошло фильтр " + source.size() + " элемента из " + sizeBeforeFiltering);

        return source;
    }
}
