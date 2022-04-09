package com.task.CDQTask.task.dto;

import com.sun.istack.Interned;
import com.sun.istack.NotNull;
import javax.persistence.criteria.CriteriaBuilder;

public record TaskRecord(@NotNull Integer base, @NotNull Integer exponent) {

    public int getBase() {
        return base;
    }

    public int getExponent() {
        return exponent;
    }
}
