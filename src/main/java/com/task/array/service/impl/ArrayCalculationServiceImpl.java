package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.service.ArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {

    private static final Logger logger = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public OptionalInt findMax(CustomArray array) {
        logger.info("Finding the maximum in an array: " + array);
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
}
