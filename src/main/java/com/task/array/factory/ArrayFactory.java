package com.task.array.factory;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

public interface ArrayFactory {
    CustomArray createWithData(int[] data) throws CustomArrayException;

    CustomArray createBySize(int size) throws CustomArrayException;
}
