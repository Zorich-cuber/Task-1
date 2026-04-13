package com.task.array.factory.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayExeption;
import com.task.array.factory.ArrayFactory;
import java.util.logging.Logger;

public class ArrayFactoryImpl implements ArrayFactory {

    private static final Logger log = Logger.getLogger(ArrayFactoryImpl.class.getName());

     @Override
    public  CustomArray createBySize(int size) {
        if (size < 0) {
            log.severe("Attempt to create an array with a negative size:" + size);
            throw new CustomArrayExeption("The size cannot be less than 0. Yours is = " + size);
        }
        log.info("The CustomArray object was successfully created. Size: " + size);
        return new CustomArray(size);
    }

     @Override
    public  CustomArray createWithData(int[] data) {
        if (data == null) {
            log.severe("Attempt to create an array of null data");
            throw new CustomArrayExeption("Данные не могут быть null");
        }
        log.info("The CustomArray object was successfully created. Size: " + data.length);
        return new CustomArray(data);
    }

}
