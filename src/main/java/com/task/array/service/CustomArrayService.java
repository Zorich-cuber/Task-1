package com.task.array.service;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayService {
    OptionalInt findMax(CustomArray array);

    OptionalInt findMin(CustomArray array);

    double sum(CustomArray array);

    OptionalDouble findAverage(CustomArray array);

    void bubbleSort(CustomArray customArray) throws CustomArrayException;

    void selectionSort(CustomArray customArray) throws CustomArrayException;
}
