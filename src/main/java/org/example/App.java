package org.example;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.factory.ArrayFactory;
import com.task.array.factory.impl.ArrayFactoryImpl;
import com.task.array.observer.ArrayObserver;
import com.task.array.observer.impl.ArrayObserverImpl;
import com.task.array.parser.DataParser;
import com.task.array.parser.DataParserimpl;
import com.task.array.reader.impl.ArrayReader;
import com.task.array.repository.ArrayRepositoryImpl;
import com.task.array.service.impl.ArrayCalculationServiceImpl;
import com.task.array.validator.impl.DataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String filePath = "data/arrays.txt";

        // Infrastructure
        ArrayReader reader = new ArrayReader();
        DataValidatorImpl validator = new DataValidatorImpl();
        DataParser parser = new DataParserimpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();

        // Prepare observer with injected service
        ArrayObserver observer = new ArrayObserverImpl(new ArrayCalculationServiceImpl());

        try {
            List<String> lines = reader.readLines(filePath);

            for (String line : lines) {
                if (validator.isValidImpl(line)) {
                    int[] numbers = parser.parseLine(line);

                    // Create array and attach observer
                    CustomArray array = factory.create(numbers);
                    array.attach(observer);

                    // Initial manual update to fill Warehouse
                    observer.update(array);

                    // Add to repository
                    repository.add(array);

                    logger.info("Processed array ID: {}", array.getId());
                } else {
                    logger.warn("Invalid line format: {}", line);
                }
            }
        } catch (CustomArrayException e) {
            logger.error("Critical error: {}", e.getMessage());
        }
    }
}
