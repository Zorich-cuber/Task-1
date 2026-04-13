package com.task.array.factory;

import com.task.array.entity.CustomArray;

public interface ArrayFactory {
    CustomArray createWithData(int[] data);

    CustomArray createBySize(int size);
}
