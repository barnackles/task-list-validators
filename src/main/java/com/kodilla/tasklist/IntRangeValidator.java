package com.kodilla.tasklist;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IntRangeValidator implements ConstraintValidator<IntRange, Integer> {

    private String annotationValue;
    private int min;
    private int max;


    @Override
    public void initialize(IntRange constraintAnnotation) {
        this.min = constraintAnnotation.min();


        this.max = constraintAnnotation.max();


    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // test if actual value passed via controller is between range.

        return value >= min && value <= max;
    }
}
