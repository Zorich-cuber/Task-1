package com.task.array.repository;

import com.task.array.entity.CustomArray;
import com.task.array.observer.impl.ArrayObserverImpl;
import com.task.array.repository.impl.ArrayRepositoryImpl;
import com.task.array.service.impl.ArrayCalculationServiceImpl;
import com.task.array.specification.IdSpecification;
import com.task.array.specification.SumGreaterThanSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryTest {
    private ArrayRepositoryImpl repository;
    private ArrayObserverImpl observer;

    @BeforeEach
    void setUp() {
        repository = ArrayRepositoryImpl.getInstance();
        // Clear repository if needed (depends on your singleton implementation)
        repository.getAll().forEach(repository::remove);

        observer = new ArrayObserverImpl(new ArrayCalculationServiceImpl());
    }

    @Test
    void testAddAndGetById() {
        CustomArray array = new CustomArray(new int[]{1, 2, 3});
        repository.add(array);

        CustomArray found = repository.getById((int) array.getId()).orElseThrow();
        assertEquals(array, found);
    }

    @Test
    void testQueryBySumSpecification() {
        // Data for 3 arrays: [1,2], [10,20], [100,200]
        CustomArray small = new CustomArray(new int[]{1, 2});     // sum 3
        CustomArray medium = new CustomArray(new int[]{10, 20});  // sum 30
        CustomArray large = new CustomArray(new int[]{100, 200}); // sum 300

        // Important: attach observer to fill Warehouse for specs to work
        List.of(small, medium, large).forEach(a -> {
            a.attach(observer);
            observer.update(a);
            repository.add(a);
        });

        // Find arrays with sum > 50 (only 'large' expected)
        List<CustomArray> result = repository.query(new SumGreaterThanSpecification(50));

        assertEquals(1, result.size());
        assertEquals(large.getId(), result.get(0).getId());
    }

    @Test
    void testSortById() {
        CustomArray a1 = new CustomArray(new int[]{1});
        CustomArray a2 = new CustomArray(new int[]{2});

        repository.add(a2);
        repository.add(a1);

        // Sorting by ID using your IdComparator (if available in classpath)
        List<CustomArray> sorted = repository.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));

        assertTrue(sorted.get(0).getId() < sorted.get(1).getId());
    }
}
