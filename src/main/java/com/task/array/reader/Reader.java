package com.task.array.reader;

import com.task.array.exception.CustomArrayExeption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    public List<String> readLines(String filePath) throws CustomArrayExeption {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {

            throw new CustomArrayExeption("Problem with file on path: " + filePath, e);
        }
    }
}
