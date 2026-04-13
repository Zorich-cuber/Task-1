package com.task.array.parser;

import com.task.array.exception.CustomArrayExeption;


public class DataParserimpl implements DataParser {
    @Override
    public int[] parseLine(String line) throws CustomArrayExeption {
        String[] parts = line.trim().split("[\\s,;-]+");

        return java.util.Arrays.stream(parts)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
