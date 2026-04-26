package com.task.array.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.task.array.observer.ArrayObservable;
import com.task.array.observer.ArrayObserver;
import com.task.array.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArray implements ArrayObservable {
    private static final Logger logger = LogManager.getLogger(CustomArray.class);

    private final long id;
    private int[] data;

    private final List<ArrayObserver> observers = new ArrayList<>();

    public CustomArray(int[] array){
        this.id = IdGenerator.generateId();
        this.data = array.clone();
    }

    public long getId() {
        return id;
    }

    public int[] getData() {
        return data.clone();
    }

    public int getSize() {
        return data.length;
    }

    public int getElement(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return data[index];
    }

    public void setElement(int index, int value) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (data[index] != value) {
            data[index] = value;
            notifyObservers();
        }
    }

    public void setElements(int[] newData) {
        if (newData == null) {
            throw new IllegalArgumentException("The data cannot be null");
        }
        this.data = newData.clone();
        notifyObservers();
    }

    @Override
    public void attach(ArrayObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver observer : new ArrayList<>(observers)) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "CustomArray{id=" + id + "data=" + Arrays.toString(data) + '}';
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
