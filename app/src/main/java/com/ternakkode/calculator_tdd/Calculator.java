package com.ternakkode.calculator_tdd;

public class Calculator {

    double val = 0.0;

    @Override
    public String toString() {
        return String.format("%.1f", this.val);
    }
}