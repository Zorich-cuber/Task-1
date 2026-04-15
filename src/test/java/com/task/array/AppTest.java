package com.task.array;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.factory.ArrayFactory;
import com.task.array.factory.impl.ArrayFactoryImpl;
import com.task.array.service.impl.CustomArrayServiceImpl;
import com.task.array.validator.DataValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CustomArray Tests")
class CustomArrayTest {

    private ArrayFactory factory;
    private CustomArrayServiceImpl service;
    private DataValidator validator;

    @BeforeEach
    void setUp() {
        factory = new ArrayFactoryImpl();
        service = new CustomArrayServiceImpl();
        validator = new DataValidator();
    }

    @Nested
    @DisplayName("CustomArray Creation")
    class CreationTests {

        @Test
        @DisplayName("Should create CustomArray with positive size")
        void shouldCreateArrayWithPositiveSize() throws CustomArrayException {
            CustomArray array = factory.createBySize(5);
            assertEquals(5, array.getData().length);
        }

        @Test
        @DisplayName("Should throw CustomArrayException for negative size")
        void shouldThrowExceptionForNegativeSize() {
            assertThrows(CustomArrayException.class, () -> factory.createBySize(-5));
        }

        @Test
        @DisplayName("Should create CustomArray from int array")
        void shouldCreateArrayFromIntData() throws CustomArrayException {
            int[] input = {10, -20, 30, 0};
            CustomArray array = factory.createWithData(input);

            assertEquals(4, array.getData().length);
        }

        @Test
        @DisplayName("Should create empty array when size is 0")
        void shouldCreateEmptyArray() throws CustomArrayException {
            CustomArray array = factory.createBySize(0);
            assertEquals(0, array.getData().length);
        }
    }

    @Nested
    @DisplayName("Element Access")
    class ElementAccessTests {

        private CustomArray array;

        @BeforeEach
        void createTestArray() throws CustomArrayException {
            array = factory.createBySize(5);
        }

        @Test
        @DisplayName("Should correctly set and get element by index")
        void shouldSetAndGetElementCorrectly() {
            array.setElement(2, 777);
            assertEquals(777, array.getElement(2));
        }

        @Test
        @DisplayName("getData() should return a defensive copy")
        void getDataShouldReturnDefensiveCopy() throws CustomArrayException {
            int[] original = {1, 2, 3};
            CustomArray arr = factory.createWithData(original);

            int[] copy = arr.getData();

            assertArrayEquals(original, copy);
            assertNotSame(original, copy);
        }
    }

    @Nested
    @DisplayName("Bulk Operations")
    class BulkOperationsTests {

        @Test
        @DisplayName("Should replace all elements using setElements()")
        void shouldReplaceAllElementsWithSetElements() throws CustomArrayException {
            CustomArray array = factory.createBySize(3);
            int[] newData = {100, 200, 300};

            array.setElements(newData);

            assertArrayEquals(newData, array.getData());
        }

        @Test
        @DisplayName("setElements() should throw IllegalArgumentException when data is null")
        void shouldThrowExceptionWhenSetElementsWithNull() throws CustomArrayException {
            CustomArray array = factory.createBySize(3);

            assertThrows(IllegalArgumentException.class,
                    () -> array.setElements(null));
        }
    }

    @Nested
    @DisplayName("Object Contract (equals, hashCode, toString)")
    class ObjectContractTests {

        @Test
        @DisplayName("Two CustomArrays with same content should be equal")
        void shouldBeEqualWhenContentIsIdentical() throws CustomArrayException {
            CustomArray arr1 = factory.createWithData(new int[]{1, 2, 3, 4});
            CustomArray arr2 = factory.createWithData(new int[]{1, 2, 3, 4});

            assertEquals(arr1, arr2);
            assertEquals(arr1.hashCode(), arr2.hashCode());
        }

        @Test
        @DisplayName("Two CustomArrays with different content should not be equal")
        void shouldNotBeEqualWhenContentDiffers() throws CustomArrayException {
            CustomArray arr1 = factory.createWithData(new int[]{1, 2, 3});
            CustomArray arr2 = factory.createWithData(new int[]{1, 2, 99});

            assertNotEquals(arr1, arr2);
        }

        @Test
        @DisplayName("toString() should contain class name and array content")
        void shouldHaveMeaningfulToString() throws CustomArrayException {
            CustomArray array = factory.createWithData(new int[]{10, 20, 30});

            String result = array.toString();

            assertTrue(result.startsWith("CustomArray:"));
            assertTrue(result.contains("[10, 20, 30]"));
        }
    }

    @Nested
    @DisplayName("DataValidator")
    class DataValidatorTests {

        @ParameterizedTest
        @DisplayName("Should validate correct numeric strings")
        @CsvSource({
                "1, 2, 3",
                "1 - 2 - 3",
                "3 4 7",
                "-5,10,-20",
                "0 0 0"
        })
        void shouldValidateCorrectInput(String input) {
            assertTrue(validator.isValid(input));
        }

        @ParameterizedTest
        @DisplayName("Should reject invalid input")
        @ValueSource(strings = {"1y1 21 32", "12.5 30", "abc def", "1,2,3.5", "1,,2"})
        @EmptySource
        @NullAndEmptySource
        void shouldRejectInvalidInput(String input) {
            assertFalse(validator.isValid(input));
        }
    }

    @Nested
    @DisplayName("CustomArrayService")
    class ServiceTests {

        @Test
        @DisplayName("findMax should return the maximum value")
        void findMaxShouldReturnMaximumValue() throws CustomArrayException {
            CustomArray array = factory.createWithData(new int[]{10, 50, 30, -100, 45});

            OptionalInt result = service.findMax(array);

            assertTrue(result.isPresent());
            assertEquals(50, result.getAsInt());
        }

        @Test
        @DisplayName("sum should calculate correct sum of elements")
        void sumShouldCalculateCorrectly() throws CustomArrayException {
            CustomArray array = factory.createWithData(new int[]{1, 2, 3, -4, 10});
            assertEquals(12.0, service.sum(array), 0.001);
        }

        @Test
        @DisplayName("sum should return 0.0 for empty array")
        void sumShouldReturnZeroForEmptyArray() throws CustomArrayException {
            CustomArray empty = factory.createBySize(0);
            assertEquals(0.0, service.sum(empty), 0.001);
        }
    }
}