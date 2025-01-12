package com.patterns;

public class PrinterAdapter implements Printer {

    //PrinterAdapter - класс-адаптер, реализует интерфейс Printer
    // и использует LegacyPrinter внутри.
    // Он адаптирует метод printOldFormat к методу print интерфейса Printer

    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String text) {
        legacyPrinter.printOldFormat(text);
    }
}
