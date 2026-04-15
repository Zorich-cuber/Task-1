package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.service.CustomArrayService;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.logging.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomArrayServiceImpl implements CustomArrayService {

    private static final Logger logger = LogManager.getLogger(CustomArrayServiceImpl.class);

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

    @Override
    public void bubbleSort(CustomArray customArray) throws CustomArrayException {
        checkArray(customArray);
        int[] array = customArray.getData();
        logger.info("Starting Bubble Sort");

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("Bubble Sort finished");
    }


    @Override
    public void selectionSort(CustomArray customArray) throws CustomArrayException {
        checkArray(customArray);
        int[] array = customArray.getData();
        logger.info("Starting Selection Sort");

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        logger.info("Selection Sort finished");
    }

    private void checkArray(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("CustomArray is null");
            throw new CustomArrayException("CustomArray cannot be null");
        }
        int[] array = customArray.getData();
        if (array == null || array.length == 0) {
            logger.error("Array is empty or null");
            throw new CustomArrayException("Array cannot be empty for sorting");
        }
    }
}
