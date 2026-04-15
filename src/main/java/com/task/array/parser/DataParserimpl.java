package com.task.array.parser;

import com.task.array.exception.CustomArrayException;

import java.util.Arrays;

public class DataParserimpl implements DataParser {

    private static final String DELIMITER_REGEX = "[\\s,;-]+";

    @Override
    public int[] parseLine(String line) throws CustomArrayException {
        String[] parts = line.trim().split(DELIMITER_REGEX);
        return Arrays.stream(parts)
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
