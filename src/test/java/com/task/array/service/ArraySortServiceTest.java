package com.task.array.service;

import com.task.array.entity.CustomArray;
import com.task.array.service.impl.ArraySortServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class ArraySortServiceTest {
    private final ArraySortServiceImpl sortService = new ArraySortServiceImpl();

    static Stream<Arguments> sortData() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 5, 2, 4}, new int[]{1, 2, 4, 5}),
                Arguments.of(new int[]{0, -1, 5, 2}, new int[]{-1, 0, 2, 5}),
                Arguments.of(new int[]{9, 9, 1, 1}, new int[]{1, 1, 9, 9})
        );
    }

    @ParameterizedTest(name = "BubbleSort {index}")
    @MethodSource("sortData")
    void testBubbleSort(int[] input, int[] expected) throws Exception {
        CustomArray customArray = new CustomArray(input);
        sortService.bubbleSort(customArray);

    }
}
