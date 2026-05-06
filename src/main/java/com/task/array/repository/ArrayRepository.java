package com.task.array.repository;

import com.task.array.entity.CustomArray;
import com.task.array.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface ArrayRepository {

    public void add(CustomArray customArray);

    public void remove(CustomArray customArray);

    public Optional<CustomArray> getById(int id);

    public List<CustomArray> getAll();

    public List<CustomArray> query(Specification specification);

    public List<CustomArray> sort(Comparator<CustomArray> comparator);
}
