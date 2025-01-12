package com.example;

import java.time.LocalDate;
import java.util.Arrays;

public class Reader {
    private String fullName;
    private String cardNumber;
    private String faculty;
    private LocalDate birthDate;
    private String phone;

    public Reader(String fullName, String cardNumber, String faculty, LocalDate birthDate, String phone) {
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public void takeBook(int bookCount) {
        System.out.println(fullName + " взял " + bookCount + " книги.");
    }

    public void takeBook(String... bookNames) {
        System.out.print(fullName + " взял книги: ");
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.print(fullName + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + ", ");
        }
        System.out.println();
    }

    public void returnBook(int bookCount) {
        System.out.println(fullName + " вернул " + bookCount + " книги.");
    }


    public void returnBook(String... bookNames) {
        System.out.print(fullName + " вернул книги: ");
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print(fullName + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + ", ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Читает{" +
                "имя файла='" + fullName + '\'' +
                ", номер карточки='" + cardNumber + '\'' +
                ", факультет='" + faculty + '\'' +
                ", дата рождения=" + birthDate +
                ", телефон='" + phone + '\'' +
                '}';
    }
}