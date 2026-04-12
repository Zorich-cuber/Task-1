package com.task.array.parser;

import com.task.array.exception.CustomArrayExeption;

public interface DataParser {
    int[] parseLine(String line) throws CustomArrayExeption;

}

