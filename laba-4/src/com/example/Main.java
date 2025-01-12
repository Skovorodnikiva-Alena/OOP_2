package com.example;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Установка кодировки консоли в UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String inputFilePath = "src/resources/tasks.txt";
        String outputFilePath = "output.txt";

        Parser parser = new Parser();
        List<String> output = new java.util.ArrayList<>();

        try {
            List<String> lines = parser.parse(inputFilePath);
            int taskNumber = 1;

            for(String line : lines) {
                output.add(parser.processLine(line, taskNumber));
                taskNumber++;
            }

            Path outputPath = Paths.get(outputFilePath);
            Files.write(outputPath,output);
            System.out.println("Результаты были записаны в " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Ощибка: " + e.getMessage());
        }
    }
}