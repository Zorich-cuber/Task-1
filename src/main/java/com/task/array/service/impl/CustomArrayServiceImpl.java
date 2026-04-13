package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.service.CustomArrayService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.logging.*;


public class CustomArrayServiceImpl implements CustomArrayService {

    private static final Logger log = Logger.getLogger(CustomArrayServiceImpl.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        } catch (Exception ignored) {
        }
    }

    @Override
    public OptionalInt findMax(CustomArray array) {
        log.info("Finding the maximum in an array: " + array);
        return Arrays.stream(array.getData())
                .max();
    }

    @Override
    public OptionalInt findMin(CustomArray array) {
        return Arrays.stream(array.getData())
                .min();

    }

    @Override
    public OptionalDouble findAverage(CustomArray array) {
        return Arrays.stream(array.getData())
                .average();
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
                .mapToInt(i -> i)
                .toArray();
        array.setElements(reversed);


    }
}
