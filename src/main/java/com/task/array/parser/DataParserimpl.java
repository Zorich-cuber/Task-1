package com.task.array.parser;

import com.task.array.exception.CustomArrayExeption;

import java.util.Arrays;

public class DataParserimpl implements DataParser {
    @Override
    public int[] parseLine(String line) throws CustomArrayExeption {
       String cleanLine = line.replaceAll("-","").trim();
       if(cleanLine.isEmpty()){
           return new int[0];
       }
       return Arrays.stream(cleanLine.split("\\s+"))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
}
