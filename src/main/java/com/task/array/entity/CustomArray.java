package com.task.array.entity;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArray {
    private static final Logger logger = LogManager.getLogger(CustomArray.class);

    private int[] data;

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

}
