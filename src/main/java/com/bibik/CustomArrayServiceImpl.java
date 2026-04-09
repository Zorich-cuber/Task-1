package com.bibik;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.*;


public class CustomArrayServiceImpl implements CustomArrayService{

    private static final Logger log = Logger.getLogger(CustomArrayServiceImpl.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        } catch (Exception ignored) {}
    }

    @Override
    public int findMax(CustomArray array) {
        log.info("Поиск максимума в массиве: " + array);
        return Arrays.stream(array.getData())
                .max()
                .orElseThrow(() -> {
                    log.severe("Ошибка: Попытка найти максимум в пустом массиве");
                   return new CustomArrayExeption("Массив пуст, максимума нет");
                });
    }

    @Override
    public int findMin(CustomArray array) {
        return Arrays.stream(array.getData())
                .min()
                .orElseThrow(()-> new CustomArrayExeption("Массив пуст, минимума нет"));

    }

    @Override
    public double sum(CustomArray array) {
        return Arrays.stream(array.getData())
                .sum();
    }

    @Override
    public void sort1(CustomArray array) {
        int[] data = array.getData();
        Arrays.sort(data);
        array.setElements(data);

    }

    @Override
    public void sort2(CustomArray array) {
        int[] reversed = Arrays.stream(array.getData())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i->i)
                .toArray();
        array.setElements(reversed);


    }
}
