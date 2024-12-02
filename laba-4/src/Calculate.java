import java.util.Arrays;

class Calculate {
    public static double calculateExpression(String expression) {
        try {
            return (double) new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка валидации входных параметров");
        }
    }

    public static double sum(double... numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static double subtract(double... numbers) {
        if (numbers.length == 0) return 0;
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double multiply(double... numbers) {
        if (numbers.length == 0) return 1;
        double result = 1;
        for (double num : numbers) {
            result *= num;
        }
        return result;
    }

    public static double divide(double... numbers) {
        if (numbers.length == 0) return 0;
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Ошибка: деление на ноль");
            }
            result /= numbers[i];
        }
        return result;
    }


    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}