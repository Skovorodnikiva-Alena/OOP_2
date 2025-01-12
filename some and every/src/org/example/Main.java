package org.example;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.utils.ArrayUtils;
import org.utils.ArrayUtilsImpl;


public class Main {
    public static void main(String[] args) {

        // Установка кодировки консоли в UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Integer[] numbers = {1, -12, 8, -4, 25, 42};

        ArrayUtils arrayUtils = new ArrayUtilsImpl();

        // Использование some
        boolean hasPositive = arrayUtils.some(numbers, n -> n > 0);
        System.out.println("Имеет положительные числа: " + hasPositive);

        // Использование every
        boolean allPositive = arrayUtils.every(numbers, n -> n > 0);
        System.out.println("Все они положительны: " + allPositive);

        boolean allEven = arrayUtils.every(numbers, n -> n % 2 == 0);
        System.out.println("Все ли равны: " + allEven);

        boolean hasNegative = arrayUtils.some(numbers, n -> n < 0);
        System.out.println("Имеет отрицательные числа: " + hasNegative);

    }
}