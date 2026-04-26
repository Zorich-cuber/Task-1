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
    public OptionalInt findMax(int[] array) {
        if (array == null || array.length == 0) {
            logger.warn("Attempt to find max in null or empty array");
            return OptionalInt.empty();
        }
        logger.info("Finding maximum in array of size: {}", array.length);
        return Arrays.stream(array).max();
    }

    @Override
    public OptionalInt findMin(int[] array) {
        if (array == null || array.length == 0) {
            logger.warn("Attempt to find min in null or empty array");
            return OptionalInt.empty();
        }
        return Arrays.stream(array).min();
    }

    @Override
    public OptionalDouble findAverage(int[] array) {
        if (array == null || array.length == 0) {
            logger.warn("Attempt to calculate average of null or empty array");
            return OptionalDouble.empty();
        }
        return Arrays.stream(array).average();
    }

    @Override
    public double sum(int[] array) {
        if (array == null || array.length == 0) {
            logger.warn("Attempt to calculate sum of null or empty array");
            return 0.0;
        }
        return Arrays.stream(array).sum();
    }
}
