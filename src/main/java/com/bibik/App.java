package com.bibik;


import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());
    static {
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        } catch (Exception ignored) {}

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CustomArray array = CustomArray.createBySize(10);

        for (int i = 0 ; i < array.getData().length; i++){
            array.setElement(i,scanner.nextInt());
            log.info("В массив добавлено число: " + array.getElement(i));
        }

        log.info("Массив успешно заполнен: ");
        CustomArrayServiceImpl  customArrayServiceImpl = new CustomArrayServiceImpl();
        int max = customArrayServiceImpl.findMax(array);
        log.info("Сортированный массив max: " + max);

    }
}
