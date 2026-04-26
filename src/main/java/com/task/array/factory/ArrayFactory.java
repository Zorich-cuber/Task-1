package com.task.array.factory;


import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

public interface ArrayFactory {

    CustomArray create(int[] elements) throws CustomArrayException;
}

