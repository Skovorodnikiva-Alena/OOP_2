package org.example;

import org.utils.ArrayUtils;
import org.utils.ArrayUtilsImpl;


public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, -12, 8, -4, 25, 42};

        ArrayUtils arrayUtils = new ArrayUtilsImpl();

        // Использование some
        boolean hasPositive = arrayUtils.some(numbers, n -> n > 0);
        System.out.println("Has positive numbers: " + hasPositive);

        // Использование every
        boolean allPositive = arrayUtils.every(numbers, n -> n > 0);
        System.out.println("Are all positive: " + allPositive);

        boolean allEven = arrayUtils.every(numbers, n -> n % 2 == 0);
        System.out.println("Are all even: " + allEven);

        boolean hasNegative = arrayUtils.some(numbers, n -> n < 0);
        System.out.println("Has negative numbers: " + hasNegative);

    }
}