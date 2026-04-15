package com.task.array.factory.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactoryImpl implements ArrayFactory {

    private static final Logger logger = LogManager.getLogger(ArrayFactoryImpl.class);

    @Override
    public CustomArray createBySize(int size) throws CustomArrayException {
        if (size < 0) {
            logger.info("Attempt to create an array with a negative size:" + size);
            throw new CustomArrayException("The size cannot be less than 0. Yours is = " + size);
        }
        logger.info("The CustomArray object was successfully created. Size: " + size);
        return new CustomArray(size);
    }

    @Override
    public CustomArray createWithData(int[] data) throws CustomArrayException {
        if (data == null) {
            logger.info("Attempt to create an array of null data");
            throw new CustomArrayException("The data cannot be null");
        }
        logger.info("The CustomArray object was successfully created. Size: " + data.length);
        return new CustomArray(data);
    }

}
