package com.task.array.reader;

import com.task.array.exception.CustomArrayException;

import java.util.List;

public interface readLines {

    public List<String> readLines(String filePath) throws CustomArrayException;
}
