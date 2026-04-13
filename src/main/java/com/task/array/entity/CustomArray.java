package com.task.array.entity;

import com.task.array.exception.CustomArrayExeption;

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

    public CustomArray(int size) {
        this.data = new int[size];
    }


    public CustomArray(int[] incomingData) {

        this.data = incomingData.clone();
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
            throw new IllegalArgumentException("The data cannot be null");
        }
        this.data = data.clone();
    }
}
