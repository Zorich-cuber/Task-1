package com.task.array.service;

import com.task.array.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayService {
    OptionalInt findMax(CustomArray array);

    OptionalInt findMin(CustomArray array);

    double sum(CustomArray array);

    OptionalDouble findAverage(CustomArray array);

    void sort1(CustomArray array);

    void sort2(CustomArray array);
}
