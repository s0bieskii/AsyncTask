package com.task.CDQTask.task.dto;


import javax.validation.constraints.NotNull;

public record TaskRecord(@NotNull Integer base, @NotNull Integer exponent) {

    public int getBase() {
        return base;
    }

    public int getExponent() {
        return exponent;
    }
}
