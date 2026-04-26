package com.task.array.validator.impl;

import com.task.array.validator.DataValidator;

public class DataValidatorImpl implements DataValidator {
    private static final String LINE_VALIDATION_REGEX = "^[\\d\\s,;-]+$";

    @Override
    public boolean isValidImpl(String line) {
        if (line == null || line.strip().isBlank()) {
            return false;
        }
        return line.matches(LINE_VALIDATION_REGEX);
    }
}
