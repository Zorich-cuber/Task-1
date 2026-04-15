package com.task.array.validator;

public class DataValidator {
    private static final String LINE_VALIDATION_REGEX = "^[\\d\\s,;-]+$";

    public boolean isValid(String line) {
        if (line == null || line.strip().isBlank()) {
            return false;
        }
        return line.matches(LINE_VALIDATION_REGEX);
    }
}
