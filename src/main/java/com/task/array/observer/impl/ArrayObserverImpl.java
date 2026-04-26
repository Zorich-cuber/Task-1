package com.task.array.observer.impl;

import com.task.array.exception.CustomArrayException;
import com.task.array.observer.ArrayObserver;
import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.service.ArrayCalculationService;
import com.task.array.service.impl.ArrayCalculationServiceImpl;
import com.task.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayObserverImpl implements ArrayObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void update(CustomArray customArray) {

        long id = customArray.getId();

        logger.info("Observer detected change in array ID: {}", id);

        ArrayCalculationService service = new ArrayCalculationServiceImpl();

        double sum = service.sum(customArray.getData());

        OptionalInt minOpt = service.findMin(customArray.getData());
        OptionalInt maxOpt = service.findMax(customArray.getData());
        OptionalDouble avgOpt = service.findAverage(customArray.getData());

        int min = minOpt.orElse(Integer.MAX_VALUE);
        int max = maxOpt.orElse(Integer.MIN_VALUE);
        double average = avgOpt.orElse(0.0);

        ArrayStatistics newStats = new ArrayStatistics(min,max,sum, average);

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        warehouse.put(id, newStats);

        logger.info("Warehouse updated for array ID: {}", id);

    }
}