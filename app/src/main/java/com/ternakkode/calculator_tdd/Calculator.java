package com.ternakkode.calculator_tdd;

public class Calculator {

    double val = 0.0;

    @Override
    public String toString() {
        return String.format("%.1f", this.val);
    }

    public void addOperation(int input) {
        this.val += input;
    }

    public void minusOperation(int input) {
        this.val -= input;
    }

    public void subtractOperation(int input) {
        this.val /= input;
    }

    public void resetCalculator() {
        this.val = 0.0;
    }
}
