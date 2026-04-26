package com.task.array.service;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayCalculationService {

    double sum(int[] array);

    OptionalInt findMax(int[] array);

    OptionalInt findMin(int[] array);

    OptionalDouble findAverage(int[] array);

}
