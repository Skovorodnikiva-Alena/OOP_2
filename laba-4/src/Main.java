import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    // Функциональный интерфейс для вычисления дискриминанта
    @FunctionalInterface
    interface DiscriminantCalculator {
        double calculate(double a, double b, double c);
    }

    private static final DecimalFormat df = new DecimalFormat("#.###");
    private static final DiscriminantCalculator discriminantCalculator = (a, b, c) -> b * b - 4 * a * c;

    public static void main(String[] args) {

        // Установка кодировки консоли в UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Parser parser = new Parser();
        String filePath = "C:\\Users\\user\\OneDrive\\Документы\\OOP_2\\laba-4\\src\\resource\\laba-4.txt";


        try {
            List<String> lines = parser.parse(filePath);
            FileWriter writer = new FileWriter("output.txt"); //Создаем output.txt
            writer.write("Выходные данные:\n");
            int taskNumber = 1;
            for (String line : lines) {
                writer.write("===Task " + taskNumber++ + "===\n");
                writer.write(line + "\n");
                processLine(line, writer);
                writer.write("\n");
            }
            writer.close();
            System.out.println("Результат записан в файл output.txt");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void processLine(String line, FileWriter writer) throws IOException {
        if (line.startsWith("Решите уравнение:")) {
            solveEquation(line, writer);
        } else if (line.startsWith("Найдите значение выражения:")) {
            calculateExpression(line, writer);
        } else if (line.startsWith("Найдите решение квадратного уравнения:")) {
            solveQuadraticEquation(line, writer);
        }
    }


    private static void solveEquation(String line, FileWriter writer) throws IOException {
        Pattern pattern = Pattern.compile("x \\+ (\\d+) = (\\d+)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(2));
            writer.write("x = " + (b - a) + "\n");
        }
    }

    private static void calculateExpression(String line, FileWriter writer) throws IOException {
        Pattern pattern = Pattern.compile("Найдите значение выражения: (.*)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String expression = matcher.group(1);
            double result = Calculate.calculateExpression(expression);
            writer.write(expression + " = " + df.format(result) + "\n");
        }
    }

    private static void solveQuadraticEquation(String line, FileWriter writer) throws IOException {
        Pattern pattern = Pattern.compile("(\\d+) \\* x \\^ 2 \\- (\\d+) \\* x \\+ (\\d+) = 0");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            double a = Double.parseDouble(matcher.group(1));
            double b = Double.parseDouble(matcher.group(2));
            double c = Double.parseDouble(matcher.group(3));
            double discriminant = discriminantCalculator.calculate(a, b, c);
            if (discriminant < 0) {
                writer.write("Дискриминант меньше нуля, решений нет.\n");
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                writer.write("x = " + df.format(x) + "\n");
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                writer.write("x1 = " + df.format(x1) + "\n");
                writer.write("x2 = " + df.format(x2) + "\n");
            }
        }
    }
}