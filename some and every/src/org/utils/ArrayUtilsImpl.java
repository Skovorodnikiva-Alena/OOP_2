package org.utils;

public class ArrayUtilsImpl implements ArrayUtils {

    @Override
    public <T> boolean some(T[] array, Condition<T> condition) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        if (condition == null) {
            throw new IllegalArgumentException("Condition cannot be null.");
        }

        for (T element : array) {
            if (condition.test(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public <T> boolean every(T[] array, Condition<T> condition) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        if (condition == null) {
            throw new IllegalArgumentException("Condition cannot be null.");
        }
        for (T element : array) {
            if (!condition.test(element)) {
                return false;
            }
        }
        return true;
    }
}