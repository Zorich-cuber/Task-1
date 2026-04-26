package com.task.array.entity;

import java.util.Objects;

public class ArrayStatistics {

    private final int min;
    private final int max;
    private final double sum;
    private final double average;

    public ArrayStatistics(int min, int max, double sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayStatistics that = (ArrayStatistics) o;
        return min == that.min && max == that.max && sum == that.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, sum);
    }

    @Override
    public String toString() {
        return String.format("Stats{min=%d, max=%d, sum=%d}", min, max, sum);
    }

}
