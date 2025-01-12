package com.example;

public class Phone {
    private String number;
    private String model;
    private double weight;

    // Конструктор без параметров
    public Phone() {
    }

    // Конструктор с двумя параметрами
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    // Конструктор с тремя параметрами (вызывает конструктор с двумя параметрами)
    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    // Метод receiveCall с одним параметром
    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    // Перегруженный метод receiveCall с двумя параметрами
    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " номер: " + callerNumber);
    }

    // Метод getNumber
    public String getNumber() {
        return number;
    }

    // Метод sendMessage с аргументами переменной длины
    public void sendMessage(String... phoneNumbers) {
        System.out.print("Сообщение отправлено на номера: ");
        for (String phoneNumber : phoneNumbers) {
            System.out.print(phoneNumber + ", ");
        }
        System.out.println();
    }

    // Геттеры и сеттеры для JavaBean

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Телефон{" +
                "номер='" + number + '\'' +
                ", модель='" + model + '\'' +
                ", вес=" + weight +
                '}';
    }
}
