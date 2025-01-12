package com.example;

import com.example.utils.ArrayUtils;
import com.example.utils.ArrayUtilsImpl;


public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, -12, 8, -4, 25, 42};

        ArrayUtils arrayUtils = new ArrayUtilsImpl();

        // Использование some
        boolean hasPositive = arrayUtils.some(numbers, n -> n > 0);
        System.out.println("Has positive numbers: " + hasPositive); // Output: Has positive numbers: true

        // Использование every
        boolean allPositive = arrayUtils.every(numbers, n -> n > 0);
        System.out.println("Are all positive: " + allPositive); // Output: Are all positive: false

        boolean allEven = arrayUtils.every(numbers, n -> n % 2 == 0);
        System.out.println("Are all even: " + allEven); // Output: Are all even: false

        boolean hasNegative = arrayUtils.some(numbers, n -> n < 0);
        System.out.println("Has negative numbers: " + hasNegative); // Output: Has negative numbers: true



        String[] words = {"apple", "banana", "cherry"};
        boolean allLongerThanThree = arrayUtils.every(words, s -> s.length() > 3);
        System.out.println("Are all words longer than 3 characters: " + allLongerThanThree); // Output: true

    }
}