package org.utils;

public class ArrayUtilsImpl implements ArrayUtils {

    @Override //Используется для переопределения методов интерфейса.
    //метод some: есть ли хотя бы один элемент массива, удовлетворяющий условию.
    public <T> boolean some(T[] array, Condition<T> condition) {
        if (array == null) { // Проверяет, не равен ли массив null
            throw new IllegalArgumentException("Массив не может быть равен null");
        }
        if (condition == null) { //Проверяет, не равно ли условие null
            throw new IllegalArgumentException("Условие не может быть нулевым");
        }

        for (T element : array) {
            if (condition.test(element)) {
                return true; //Если test() возвращает true, то возвращает true
            }
        }
        return false; // Если  все элементы не удовлетворяют условию, то возвращает false.
    }

    @Override
    //метод every: проверяет, все ли элементы массива удовлетворяют условию
    public <T> boolean every(T[] array, Condition<T> condition) {
        if (array == null) { // Проверяет, не равен ли массив null
            throw new IllegalArgumentException("Массив не может быть равен null");
        }
        if (condition == null) { //Проверяет, не равно ли условие null
            throw new IllegalArgumentException("Условие не может быть нулевым");
        }
        for (T element : array) {
            if (!condition.test(element)) {
                return false; // Если test() возвращает false, то возвращает false
            }
        }
        return true; // Если  все элементы удовлетворяют условию, то возвращает true
    }
}