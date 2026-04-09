package com.bibik;

import java.util.logging.*;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class CustomArray {
    private static final Logger log = Logger.getLogger(CustomArray.class.getName());
    private int[] data;

    static {
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        } catch (Exception ignored) {
        }
    }

    private CustomArray(int size) {
        this.data = new int[size];
    }


    private CustomArray(int... incomingData) {

        this.data = incomingData.clone();
    }


    public static CustomArray createBySize(int size) {
        if (size < 0) {
            log.severe("Попытка создания массива с отрицательным размером:" + size);
            throw new CustomArrayExeption("Размер не может быть меньше 0. У вас равен = " + size);
        }
        log.info("Объект CustomArray успешно создан. Размер:" + size);
        return new CustomArray(size);
    }


    public static CustomArray createWithData(int... data) {
        if (data == null) {
            log.severe("Попытка создать массив из null данных");
            throw new CustomArrayExeption("Данные не могут быть null");
        }
        log.info("Объект CustomArray успешно создан. Размер: " + data.length);
        return new CustomArray(data);
    }

    @Override
    public String toString() {
        return "CustomArray: " + Arrays.toString(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    public int[] getData() {
        return data.clone();
    }

    public void setElement(int index, int value) {
        this.data[index] = value;
    }

    public int getElement(int index) {
        return this.data[index];
    }

    public void setElements(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Данные не могут быть null");
        }
        this.data = data.clone();
    }
}
