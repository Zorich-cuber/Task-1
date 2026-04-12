package com.task.array.service;

import com.task.array.entity.CustomArray;

public interface CustomArrayService {
    int findMax(CustomArray array);
    int findMin(CustomArray array);
    double sum(CustomArray array);
    void sort1(CustomArray array);
    void sort2(CustomArray array);
}
