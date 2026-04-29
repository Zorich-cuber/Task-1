package com.task.array.parser;

import com.task.array.parser.DataParserimpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DataParserTest {
    private final DataParserimpl parser = new DataParserimpl();

    static Stream<Arguments> parseData() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4",    new int[]{1, 2, 3, 4}),
                Arguments.of("10 20 30 40",   new int[]{10, 20, 30, 40}),
                Arguments.of("1;2;3;4",       new int[]{1, 2, 3, 4}),
                Arguments.of(" 5 - 6 - 7 - 8", new int[]{5, 6, 7, 8})
        );
    }

    @ParameterizedTest(name = "Parse {index}: ''{0}''")
    @MethodSource("parseData")
    void testParseLine(String input, int[] expected) throws Exception {
        assertArrayEquals(expected, parser.parseLine(input));
    }
}
