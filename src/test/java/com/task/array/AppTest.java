package com.task.array;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testCreateAndGetElement() {
        CustomArray array = CustomArray.createBySize(5);

        array.setElement(0, 100);

        assertEquals(100, array.getElement(0));
    }

    @Test
    void testNegativeSize() {
        assertThrows(CustomArrayExeption.class, () -> {
            CustomArray.createBySize(-5);
        });
    }
}
