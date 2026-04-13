package com.task.array.validator;

public class DataValidator {
    private static final String VALID_REGEX = "^[\\d\\s,;-]+$";

    public boolean isValid(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        return line.matches(VALID_REGEX);
    }
}
