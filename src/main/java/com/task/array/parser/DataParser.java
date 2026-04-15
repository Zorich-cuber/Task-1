package com.task.array.parser;

import com.task.array.exception.CustomArrayException;

public interface DataParser {
    int[] parseLine(String line) throws CustomArrayException;

}

