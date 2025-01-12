package com.example;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Установка кодировки консоли в UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 1-3. Создание и вывод Phone
        Phone phone1 = new Phone("123-456-7890", "Samsung", 150.0);
        Phone phone2 = new Phone("987-654-3210", "iPhone");
        Phone phone3 = new Phone();
        phone3.setNumber("111-222-3333");
        phone3.setModel("Nokia");
        phone3.setWeight(120.5);

        System.out.println(phone1.toString());
        System.out.println(phone2.toString());
        System.out.println(phone3.toString());


        // 4. Вызов методов receiveCall и getNumber
        phone1.receiveCall("Джон");
        System.out.println("Номер телефона 1: " + phone1.getNumber());

        phone2.receiveCall("Анна");
        System.out.println("Номер телефона 2: " + phone2.getNumber());

        phone3.receiveCall("Пётр");
        System.out.println("Номер телефона 3: " + phone3.getNumber());

        // 9.  Вызов перегруженного receiveCall
        phone1.receiveCall("Мария", "555-123-4567");

        //10. Вызов sendMessage
        phone1.sendMessage("111-111-1111", "222-222-2222", "333-333-3333");


        // 7. Создание массива объектов Reader
        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Петров В. В.", "12345", "Информатика", LocalDate.of(1990, 5, 15), "555-1111");
        readers[1] = new Reader("Иванова А. Б.", "67890", "Математика", LocalDate.of(1992, 10, 20), "555-2222");
        readers[2] = new Reader("Сидоров С. Д.", "24680", "Физика", LocalDate.of(1991, 2, 10), "555-3333");

        for(Reader reader : readers) {
            System.out.println(reader.toString());
        }

        // 8. Перегруженные методы takeBook
        readers[0].takeBook(3);
        readers[1].takeBook("Приключения", "Словарь", "Энциклопедия");
        readers[2].takeBook(new Book("Приключения", "Автор1"), new Book("Словарь", "Автор2"), new Book("Энциклопедия", "Автор3"));

        // 9. Перегруженные методы returnBook
        readers[0].returnBook(2);
        readers[1].returnBook("Приключения", "Словарь", "Энциклопедия");
        readers[2].returnBook(new Book("Приключения", "Автор1"), new Book("Словарь", "Автор2"), new Book("Энциклопедия", "Автор3"));
    }
}