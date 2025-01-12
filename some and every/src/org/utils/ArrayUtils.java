package org.utils;

public interface ArrayUtils {
    <T> boolean some(T[] array, Condition<T> condition);
    <T> boolean every(T[] array, Condition<T> condition);

    interface Condition<T> {
        boolean test(T element);
    }
}