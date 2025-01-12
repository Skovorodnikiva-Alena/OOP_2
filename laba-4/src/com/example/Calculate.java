package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate {

    public static double add(double... numbers) {
        validateNumbers(numbers);
        double result = 0;
        for (double num : numbers) {
            result += num;
        }
        return round(result);
    }

    public static double subtract(double... numbers) {
        validateNumbers(numbers);
        if (numbers.length == 0) {
            return 0; // или выкидывайте исключение
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return round(result);
    }

    public static double multiply(double... numbers) {
        validateNumbers(numbers);
        double result = 1;
        for (double num : numbers) {
            result *= num;
        }
        return round(result);
    }


    public static double divide(double... numbers) {
        validateNumbers(numbers);
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Ошибка: Недостаточно аргументов для деления");
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Ошибка: деление на ноль");
            }
            result /= numbers[i];
        }
        return round(result);
    }

    private static void validateNumbers(double... numbers) {
        for (double num : numbers) {
            if (Double.isNaN(num)) {
                throw new IllegalArgumentException("Ошибка валидации входных параметров");
            }
        }
    }


    private static double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
