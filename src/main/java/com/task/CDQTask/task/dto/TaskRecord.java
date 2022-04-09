package com.task.CDQTask.task.dto;

public record TaskRecord(int base, int exponent) {

    public int getBase() {
        return base;
    }

    public int getExponent() {
        return exponent;
    }
}
