package com.task.array.observer;

import com.task.array.entity.CustomArray;
import com.task.array.entity.ArrayStatistics;
import com.task.array.observer.impl.ArrayObserverImpl;
import com.task.array.service.impl.ArrayCalculationServiceImpl;
import com.task.array.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObserverIntegrationTest {

    private ArrayObserverImpl observer;
    private ArrayWarehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouse = ArrayWarehouse.getInstance();
        warehouse.clear();
        observer = new ArrayObserverImpl(new ArrayCalculationServiceImpl());
    }

    static Stream<Arguments> observerDataProvider() {
        return Stream.of(

                Arguments.of(new int[]{1, 2, 3, 4}, 1, 4, 10.0),
                Arguments.of(new int[]{-10, 0, 10, 20}, -10, 20, 20.0),
                Arguments.of(new int[]{5, 5, 5, 5}, 5, 5, 20.0),
                Arguments.of(new int[]{100, 1, 2, 3}, 1, 100, 106.0)
        );
    }

    @ParameterizedTest(name = "Run {index}: input={0}")
    @MethodSource("observerDataProvider")
    void testObserverUpdatesWarehouseCorrectly(int[] data, int min, int max, double sum) {
        CustomArray array = new CustomArray(data);


        observer.update(array);

        ArrayStatistics stats = warehouse.get(array.getId());

        assertEquals(min, stats.getMin(), "Min mismatch");
        assertEquals(max, stats.getMax(), "Max mismatch");
        assertEquals(sum, stats.getSum(), "Sum mismatch");
    }
}
