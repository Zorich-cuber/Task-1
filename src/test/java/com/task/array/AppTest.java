package com.task.array;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayExeption;
import com.task.array.service.impl.CustomArrayServiceImpl;
import com.task.array.factory.ArrayFactory;
import com.task.array.factory.impl.ArrayFactoryImpl;
import com.task.array.validator.DataValidator;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private final ArrayFactory factory = new ArrayFactoryImpl();
    private final CustomArrayServiceImpl service = new CustomArrayServiceImpl();
    private final DataValidator validator = new DataValidator();

    @Test
    void testCreateAndGetElement() {

        CustomArray array = factory.createBySize(5);
        array.setElement(0, 100);
        assertEquals(100, array.getElement(0));
    }

    @Test
    void testNegativeSize() {

        assertThrows(CustomArrayExeption.class, () -> {
            factory.createBySize(-5);
        });
    }

    @Test
    void testValidatorCorrectData() {
        assertTrue(validator.isValid("1, 2, 3"));
        assertTrue(validator.isValid("1 - 2 - 3"));
        assertTrue(validator.isValid("3 4 7"));
    }

    @Test
    void testValidatorIncorrectData() {
        assertFalse(validator.isValid("1y1 21 32"));
        assertFalse(validator.isValid("12.5 30"));
        assertFalse(validator.isValid(""));
    }

    @Test
    void testServiceFindMax() {
        CustomArray array = factory.createWithData(new int[]{10, 50, 30});
        OptionalInt result = service.findMax(array);

        assertTrue(result.isPresent(), "Max should be present");
        assertEquals(50, result.getAsInt());
    }

    @Test
    void testServiceSum() {
        CustomArray array = factory.createWithData(new int[]{1, 2, 3});
        assertEquals(6.0, service.sum(array), 0.001);
    }
}
