package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public List<String> parse(String path) throws IOException {
        Path filePath = Paths.get(path);
        if (!Files.exists(filePath)) {
            throw new IOException("Файл " + path + " не найден");
        }

        return Files.readAllLines(filePath);
    }

    public  String processLine(String line, int taskNumber) {
        String result = "===Task " + taskNumber + "===\n" + line + "\n";
        if (line.contains("Решите уравнение:")) {
            try {
                result += solveLinearEquation(line);
            } catch (Exception e) {
                result += "Уравнение для решения ошибок " + e.getMessage() + "\n";
            }
        } else if (line.contains("Найдите значение выражения:")) {
            try {
                result += calculateExpression(line);
            } catch (Exception e) {
                result +=  "Ошибка при вычислении выражения " + e.getMessage() + "\n";
            }
        } else if (line.contains("Найдите решение квадратного уравнения:")) {
            try {
                String quadraticResult = solveQuadraticEquation(line);
                result += quadraticResult; // Добавил эту строку

            } catch (Exception e) {
                result +=  "Ошибка при вычислении квадратного уравнения " + e.getMessage() + "\n";
            }
        }
        return result;
    }

    private String solveLinearEquation(String line) {
        Pattern pattern = Pattern.compile("([a-zA-Z])\\s*([+\\-\\*/])\\s*([\\d.]+)\\s*=\\s*([\\d.]+)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String variable = matcher.group(1);
            String operation = matcher.group(2);
            double operand1 = Double.parseDouble(matcher.group(3));
            double result = 0;
            double sum = Double.parseDouble(matcher.group(4));
            switch(operation) {
                case "+":
                    result = Calculate.subtract(sum, operand1);
                    break;
                case "-":
                    result = Calculate.add(sum, operand1);
                    break;
                case "*":
                    result = Calculate.divide(sum, operand1);
                    break;
                case "/":
                    result = Calculate.multiply(sum, operand1);
                    break;
            }
            return  variable + " = " + result + "\n";
        } else {
            return "Неправильный формат уравнения \n";
        }
    }


    private String calculateExpression(String line) {
        String expression = line.substring(line.indexOf(":") + 2).trim();
        Pattern pattern = Pattern.compile("([\\d.]+)|([+\\-\\*/])");

        Matcher matcher = pattern.matcher(expression);
        List<Double> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        while(matcher.find()) {
            if(matcher.group(1) != null) {
                try {
                    numbers.add(Double.parseDouble(matcher.group(1)));
                } catch(NumberFormatException e) {
                    throw new IllegalArgumentException("Неправильный формат чисел " + matcher.group(1));
                }
            }
            else if (matcher.group(2) != null) {
                operations.add(matcher.group(2));
            }
        }

        double result = numbers.get(0);
        int numIndex = 1;
        for (String operation : operations) {
            if(operation.equals("+")) {
                result = Calculate.add(result, numbers.get(numIndex));
            } else if(operation.equals("-")) {
                result = Calculate.subtract(result, numbers.get(numIndex));
            } else if(operation.equals("*")) {
                result = Calculate.multiply(result, numbers.get(numIndex));
            } else if(operation.equals("/")) {
                result = Calculate.divide(result, numbers.get(numIndex));
            }
            numIndex++;
        }


        return expression + " = " + result + "\n";
    }


    private String solveQuadraticEquation(String line) {
        Pattern pattern = Pattern.compile("([\\d.]+)\\s*\\*\\s*x\\s*\\^\\s*2\\s*([+\\-])\\s*([\\d.]+)\\s*\\*\\s*x\\s*([+\\-])\\s*([\\d.]+)\\s*=\\s*0");
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()) {
            double a = Double.parseDouble(matcher.group(1));
            double signB = matcher.group(2).equals("+") ? 1 : -1;
            double b = signB * Double.parseDouble(matcher.group(3));
            double signC = matcher.group(4).equals("+") ? 1 : -1;
            double c = signC * Double.parseDouble(matcher.group(5));

            DiscriminantCalculator discriminant = (double x, double y, double z) -> (y * y) - 4 * x * z;
            double d =  discriminant.calculate(a, b, c);
            if(d < 0) {
                return "Корней нет, значение дискриминанта меньше нуля: " + String.format("%.3f", d) + "\n";
            }

            double x1 = Calculate.divide(Calculate.subtract(-b, Math.sqrt(d)),(2*a)) ;
            double x2 =  Calculate.divide(Calculate.add(-b, Math.sqrt(d)),(2*a));
            return "x1 = " +  x1  + " x2 = " + x2 + "\n";

        } else {
            return "Неправильный формат квадратного уравнения \n";
        }
    }
}