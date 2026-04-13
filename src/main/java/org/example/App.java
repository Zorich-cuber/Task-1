package org.example;

import com.task.array.parser.DataParserimpl;
import com.task.array.service.impl.CustomArrayServiceImpl;
import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayExeption;
import com.task.array.reader.Reader;
import com.task.array.validator.DataValidator;
import com.task.array.parser.DataParser;
import com.task.array.factory.ArrayFactory;
import com.task.array.factory.impl.ArrayFactoryImpl;

import java.util.OptionalInt;
import java.util.logging.Logger;
import java.util.List;

public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        String filePath = "data/arrays.txt";
        Reader reader = new Reader();
        DataValidator validator = new DataValidator();
        DataParser parser = new DataParserimpl();
        CustomArrayServiceImpl service = new CustomArrayServiceImpl();

        ArrayFactory factory = new ArrayFactoryImpl();

        try {
            List<String> lines = reader.readLines(filePath);
            for (String line : lines) {
                if (validator.isValid(line)) {
                    int[] numbers = parser.parseLine(line);

                    CustomArray array = factory.createWithData(numbers);

                    OptionalInt max = service.findMax(array);

                    if (max.isPresent()) {
                        log.info("Array from file processed. Max: " + max.getAsInt());
                    } else {
                        log.warning("The array was empty");
                    }
                } else {
                    log.warning("Line missing (incorrect format or empty): " + line);
                }
            }

        } catch (CustomArrayExeption e) {
            log.severe("Error while working with data: " + e.getMessage());
        }
    }
}
