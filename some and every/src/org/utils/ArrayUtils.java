package org.utils;

public interface ArrayUtils {
    //Возвращает true, если хотя бы один элемент массива удовлетворяет условию, иначе false
    <T> boolean some(T[] array, Condition<T> condition);
    //Возвращает true, если все элементы массива удовлетворяют условию, иначе false.
    <T> boolean every(T[] array, Condition<T> condition);

    interface Condition<T> { //Объявляет вложенный интерфейс Condition,
        // который определяет метод test, используемый для проверки условия
        boolean test(T element);
    }
}