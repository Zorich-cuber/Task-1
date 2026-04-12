package com.task.array;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayExeption;
import com.task.array.service.impl.CustomArrayServiceImpl;
import com.task.array.validator.DataValidator;
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

    @Test
    void testValidatorCorrectData() {
        DataValidator validator = new DataValidator();
        assertTrue(validator.isValid("1, 2, 3"));
        assertTrue(validator.isValid("1 - 2 - 3"));
        assertTrue(validator.isValid("3 4 7"));
    }

    @Test
    void testValidatorIncorrectData() {
        DataValidator validator = new DataValidator();
        assertFalse(validator.isValid("1y1 21 32"));
        assertFalse(validator.isValid("12.5 30"));
    }
    @Test
    void testServiceFindMax() {
        CustomArrayServiceImpl service = new CustomArrayServiceImpl();

        CustomArray array = CustomArray.createWithData(new int[]{10, 50, 30});
        assertEquals(50, service.findMax(array));
    }

    @Test
    void testServiceSum() {
        CustomArrayServiceImpl service = new CustomArrayServiceImpl();

        CustomArray array = CustomArray.createWithData(new int[]{1, 2, 3});
        assertEquals(6.0, service.sum(array), 0.001);
    }


}
