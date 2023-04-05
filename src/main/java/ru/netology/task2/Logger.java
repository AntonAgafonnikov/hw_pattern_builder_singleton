package ru.netology.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private int num = 1;
    private static Logger logger;

    private Logger() {
    }

    public void log(String msg) {
        StringBuilder sb = new StringBuilder()
                .append("[")
                .append(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss ")))
                .append(num++)
                .append("] ")
                .append(msg);

        System.out.println(sb);
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }
}
