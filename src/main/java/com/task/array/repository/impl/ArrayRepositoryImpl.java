package com.task.array.repository.impl;

import com.task.array.entity.CustomArray;
import com.task.array.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;

public class ArrayRepositoryImpl implements ArrayRepository {

    private static final Logger logger = LogManager.getLogger();

    private static ArrayRepositoryImpl instance;

    private final List<CustomArray> arrays;

    private ArrayRepositoryImpl() {
        this.arrays = new ArrayList<>();
    }

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
            logger.info("ArrayRepository singleton created");
        }

        return instance;
    }

    @Override
    public void add(CustomArray customArray) {
        arrays.add(customArray);
        logger.info("Added array with ID {} to repository", customArray.getId());
    }

    @Override
    public void remove(CustomArray customArray) {
        arrays.remove(customArray);
        logger.info("Removed array with ID {} from repository", customArray.getId());
    }

    @Override
    public Optional<CustomArray> getById(int id) {
        for (CustomArray arr : arrays) {
            if (arr.getId() == id) {
                return Optional.of(arr);
            }
        }
        logger.warn("Array with ID {} not found", id);
        return Optional.empty();
    }

    @Override
    public List<CustomArray> getAll() {
        return new ArrayList<>(arrays);
    }

    @Override
    public List<CustomArray> query(Specification specification) {

        List<CustomArray> results = new ArrayList<>();

        for (CustomArray arr : arrays) {
            if (specification.specify(arr)) {
                results.add(arr);
            }
        }

        logger.info("Query performed. Found {} arrays.", results.size());
        return results;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {

        List<CustomArray> sortedList = new ArrayList<>(arrays);

        sortedList.sort(comparator);

        logger.info("Arrays sorted using comparator: {}", comparator.getClass().getSimpleName());
        return sortedList;
    }


}