package com.task.array.validator;

import com.task.array.validator.impl.DataValidatorImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataValidatorTest {
    private final DataValidatorImpl validator = new DataValidatorImpl();

    static Stream<Arguments> validationData() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4", true),
                Arguments.of("10-20-30-40", true),
                Arguments.of("text 1 2 3", false),
                Arguments.of("1.5, 2, 3", false)
        );
    }

    @ParameterizedTest(name = "Check {index}: line=''{0}'', valid={1}")
    @MethodSource("validationData")
    void testIsValid(String line, boolean expected) {
        assertEquals(expected, validator.isValidImpl(line));
    }
}
