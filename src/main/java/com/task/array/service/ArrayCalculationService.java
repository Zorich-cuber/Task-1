package com.task.array.service;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayCalculationService {

    double sum(CustomArray array);

    OptionalInt findMax(CustomArray array);

    OptionalInt findMin(CustomArray array);

    OptionalDouble findAverage(CustomArray array);

}
