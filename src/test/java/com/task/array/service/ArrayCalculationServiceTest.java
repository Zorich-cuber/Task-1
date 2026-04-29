package com.task.array.service;

import com.task.array.service.impl.ArrayCalculationServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayCalculationServiceTest {
    private final ArrayCalculationServiceImpl service = new ArrayCalculationServiceImpl();

    static Stream<Arguments> sumData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 10.0),
                Arguments.of(new int[]{-1, 0, 1, 2}, 2.0),
                Arguments.of(new int[]{5, 5, 5, 5}, 20.0),
                Arguments.of(new int[]{10, 20, 30, 40}, 100.0)
        );
    }

    @ParameterizedTest(name = "Run {index}: input={0}, sum={1}")
    @MethodSource("sumData")
    void testSum(int[] input, double expected) {
        assertEquals(expected, service.sum(input));
    }

    static Stream<Arguments> avgData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2.5),
                Arguments.of(new int[]{10, 10, 10, 10}, 10.0),
                Arguments.of(new int[]{0, 0, 0, 0}, 0.0),
                Arguments.of(new int[]{2, 4, 6, 8}, 5.0)
        );
    }

    @ParameterizedTest(name = "Run {index}: input={0}, avg={1}")
    @MethodSource("avgData")
    void testAverage(int[] input, double expected) {
        assertEquals(expected, service.findAverage(input).orElse(0), 0.001);
    }
}
