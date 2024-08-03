package com.codestorm.learn.records;

public record RecordPrinter(String value) implements CustomPrinter {
    @Override
    public void printValue() {
        System.out.println("Printing the value :" + value);
    }
}
