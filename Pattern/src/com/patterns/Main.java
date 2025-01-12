package com.patterns;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {

        // Установка кодировки консоли в UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Тестирование Singleton
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        config1.setAppName("My App");
        config1.setLogLevel("DEBUG");
        config1.printConfiguration();

        ConfigurationManager config2 = ConfigurationManager.getInstance();
        config2.printConfiguration(); // Выведет те же настройки, т.к. это тот же объект

        System.out.println("Являются ли обе конфигурации одним и тем же объектом? " + (config1 == config2));

        // Тестирование Adapter
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer adapter = new PrinterAdapter(legacyPrinter);

        adapter.print("Hello, world!"); // Используем старый принтер через адаптер
    }
}