package com.task.array.reader.impl;

import com.task.array.exception.CustomArrayException;
import com.task.array.reader.readLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayReader implements readLines {

    @Override
    public List<String> readLines(String filePath) throws CustomArrayException {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {

            throw new CustomArrayException("Problem with file on path: " + filePath, e);
        }
    }
}
